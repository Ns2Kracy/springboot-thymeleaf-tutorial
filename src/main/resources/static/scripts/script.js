function search(){
    $("#studentTable").bootstrapTable("destroy");
    loadTable();
}

function saveStudent(){
    $("#studentModal").modal("show");
    let data=$("#studentForm").serialize();
    let id = $("#studentId").val();
    if (id < 1) {//新增
        $.ajax({
            url: "/webapi/student/insert",
            method: "post",
            data: data
        }).done(function () {
            loadTable();
            $('#studentTable').bootstrapTable('refresh');
            $("#studentModal").modal('hide')
        })
    } else {
        //更新
        $.ajax({
            url: "/webapi/student/update/" + id,
            method: "put",
            data: data
        }).done(function () {
            loadTable();
            $('#studentTable').bootstrapTable('refresh');
            $("#studentModal").modal('hide')
        })
    }
}

function editStudent(id){
    let data=$("#studentForm").serialize();
    $("#studentModal").modal("show");
    $.ajax({
        url: "/webapi/student/getid/" + id,
        type: "GET",
        method: "GET",
        data: data
    }).done(function (data) {
        $("#studentId").val(data.id);
        $("#name").val(data.name);
        $("#password").val("");
        $("#no").val(data.no);
        $("#sex").val(data.sex);
        $("#score").val(data.score);
    });
}

function deleteStudent(id){
    if (confirm("确定删除吗？")){
        $.ajax({
            url: "/webapi/student/delete/" + id,
            type: "DELETE",
            data: id,
            method: "DELETE",
        }).done(function () {
            alert("删除成功");
            loadTable()
        });
    }
}

function loadTable(){
    $("#studentTable").bootstrapTable({
        method: 'GET',
        url: '/webapi/student/page',
        iconSize: 'outline',
        pageSize: 10,
        pageNumber: 1,
        pagination: true,
        dataType: 'json',
        singleSelect: false,
        sidePagination: 'server',
        queryParams: function (params) {
            return {
                size: params.limit,
                page: params.offset / params.limit,
                sort: 'id',
                direct: 'desc',
                name: $('#findByName').val()
            };
        },
        columns: [{
            field: 'id',
            title: 'ID'
        },{
            field: 'name',
            title: '姓名'
        },{
            field: 'no',
            title: '学号'
        },{
            field: 'sex',
            title: '性别'
        },{
            field: 'score',
            title: '成绩'
        },{
            // 这里是操作按钮
            title: '操作',
            // 创建编辑和删除按钮
            formatter: function (value, row) {
                return '<button type="button" ' +
                    'class="btn btn-primary" ' +
                    'onclick="editStudent(' + row.id + ')" style="margin-right: 10px">' +
                    '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>' +
                    '</button>' +
                    '<button ' +
                    'class="btn btn-danger" ' +
                    'onclick="deleteStudent(' + row.id + ')">' +
                    '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
                    '</button>';
            }
        }]
    });
}

$(function (){
    loadTable();
})
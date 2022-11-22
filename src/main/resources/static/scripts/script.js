function saveStudent(){
    let data=$("#save-form").serialize();
    let id = $("#id").val();
    if (id === ""){
        $.ajax({
            url:"/webapi/student/insert",
            method:"POST",
            data: data
        }).done(function () {
            loadTable();
            $("#saveModal").modal('hide')
        });
    } else {
        $.ajax({
            url:"/webapi/student/update",
            method:"POST",
            data: data
        }).done(function () {
            loadTable();
            $("#saveModal").modal('hide')
        });
    }
}

function editStudent(param){
    $("#saveModal").modal("show");
    $.ajax({
        url: "/webapi/student/getid/" + param,
        type: "GET",
        method: "GET",
    }).done(function (data) {
        $("#save-id").val(data.id);
        $("#name").val(data.name);
        $("#password").val("");
        $("#no").val(data.no);
        $("#sex").val(data.sex);
        $("#score").val(data.score);
        loadTable()
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

function findClick() {
    let name = $("#findId").val();
    findStudent(name);
}

function findStudent(name) {
    $.ajax({
        url: "/webapi/student/getid/" + name,
        method:"get",
    }).done(function (data) {
        if (data.length === 0){
            alert("没有找到");
            loadTable();
        } else {
            $("#save-id").val(data[0].id);
            $("#name").val(data[0].name);
            $("#no").val(data[0].no);
            $("#password").val("");
            $("#sex").val(data[0].sex);
            $("#score").val(data[0].score);
        }
    })
}

function loadTable(){
    $.ajax({
        url: "/webapi/student/list",
        type: "GET",
        success:studentList
    })
}

function studentList(data){
    let len = data.length;
    let html = "";
    for (let i = 0; i < len; i++) {
        let item = data[i];
        html += "<tr>"
            + "<td style='width: 10%'>" + item.id + "</td>"
            + "<td style='width: 17.5%'>" + item.name + "</td>"
            + "<td style='width: 17.5%'>" + item.no + "</td>"
            + "<td style='width: 17.5%'>" + item.sex + "</td>"
            + "<td style='width: 17.5%'>" + item.score + "</td>"
            + "<td style='width: 20%'>" +
            "<button type='button' class='btn btn-primary' onclick='editStudent(" + item.id + ")' style='margin-right: 10px'>" +
            "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span></button>" +
            "<button type='button' class='btn btn-danger' onclick='deleteStudent(" + item.id + ")'>" +
            "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button>" +
            "</td>"
            + "</tr>";
    }
    $("#studentTB").html(html);
}


$(function (){
    loadTable();
})
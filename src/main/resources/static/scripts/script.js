$(function (){
    loadTable();
})

function addStudent(){
    let student = $("#student-form").serialize();
    $.ajax({
        url: "/webapi/student/insert",
        type: "POST",
        data: student,
        method: "POST",
    }).done(function () {
        $("#myModal").modal("hide");
        loadTable();
    });
}

function searchStudent(param){
    $.ajax({
        url: "/webapi/student/" + param,
        type: "GET",
        method: "GET",
        success: returnList,
    })
}

function editStudent(id){
    $.ajax({
        url: "/webapi/student" + id,
        type: "GET",
        method: "GET",
    }).done(function (data) {
        $("#id").val(data.id);
        $("#name").val(data.name);
        $("#password").val(data.password);
        $("#no").val(data.no);
        $("#sex").val(data.sex);
        $("#score").val(data.score);
        $("#myModal").modal("show");
    });
}

function deleteStudent(id){
    $.ajax({
        url: "/webapi/student/delete/" + id,
        type: "DELETE",
        method: "DELETE",
    }).done(function () {
        alert("删除成功");
        loadTable();
    });
}

function loadTable(){
    $.ajax({
        url: "/webapi/student/list",
        type: "GET",
        success: returnList,
    })
}

function returnList(data){
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
            "<span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>" + "Edit" + "</button>" +
            "<button type='button' class='btn btn-danger' onclick='deleteStudent(" + item.id + ")'>" +
            "<span class='glyphicon glyphicon-remove' aria-hidden='true'></span>" + "Delete" + "</button>" +
            "</td>"
            + "</tr>";
    }
    $("#studentTB").html(html);
}

$(document).ready(function(){
    addPerson();
//    editPerson();
//    deletePerson();
//    getPerson();
});
function addPerson()
{
    $("#addPerson").click(function ()
    {
        var fn = $("#FN").val();
        var ln = $("#LN").val();
        var email = $("#Email").val();

        $.ajax({
            url: "http://localhost:8080/CA-2/api/person/add",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                fn: fn,
                ln: ln,
                email: email }),
            success: function ()
            {
                console.log("Added new person:" + fn + " " + ln + " " + email);
            }
        });
    });
}
//function deletePerson()
//{
//    $("#deletePerson").click(function ()
//    {
//        var ID = $("#ID").val();
//
//        $.ajax({
//            url: "http://localhost:8080/CA_2/api/person/delete",
//            type: "",
//            contentType: "application/json",
//            data: JSON.stringify({
//                id: id, }),
//            success: function ()
//            {
//            }
//        });
//    });
//}
//function editPerson()
//{
//    $("#editPerson").click(function ()
//    {
//        var ID = $("#ID").val();
//
//        $.ajax({
//            url: "http://localhost:8080/CA_2/api/person/edit",
//            type: "",
//            contentType: "application/json",
//            data: JSON.stringify({
//                id: id, }),
//            success: function ()
//            {
//            }
//        });
//    });
//}
//function getPerson()
//{
//    $("#addP").click(function ()
//    {
//        var id = $("#ID").val();
//
//        $.ajax({
//            url: "http://localhost:8080/CA_2/api/person/get",
//            type: "GET",
//            contentType: "application/json",
//            data: JSON.stringify({
//                id: id, }),
//            success: function ()
//            {
//            }
//        });
//    });
//}
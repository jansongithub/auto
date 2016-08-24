/**
 * Created by zhanxiaobing on 2016/8/3.
 */

var customer_register_form_subFlag = 0;

function tijiao(){
    if(customer_register_form_subFlag==0){
        checkRepeat();
        return false;
        alert("bbbbbbbbbbb")
    }else{
        //console.info("�Ѿ��ύ�����Եȡ�����������");
        alert("ttttttttttt")
    }
}

function checkRepeat(){
   // var Intername1 = document.getElementById("Intername");   Intername1.value()
    var projectname1 =  $("#projectname option:selected").text();
    var Intername1 =  $("#Intername").val();
    var Casename1 =  $("#Casename").val();
    var method1 =  $("#method option:selected").text();
    var host1 =  $("#host").val();
    var URI1 =  $("#URI").val();
    var Accept1 =  $("#Accept").val();
    var ContentType1 =  $("#ContentType").val();
    var islogin1 =  $("#islogin").val();
    var loginname1 =  $("#loginname").val();
    var ResultResponse1 =  $("#ResultResponse").val();
    var ResultResponseType1=  $("#ResultResponseType").val();


    if (projectname1 == "请选择") {
        $("#adderrmsg").html("请选择项目");
        $("#projectname").focus();
        return;
    }

    if ("" == Intername1) {
        $("#adderrmsg").html("接口名称不能为空");
        $("#Intername").focus();
        return;
    }
    if (Casename1 == "") {
        $("#adderrmsg").html("用例名称不能为空");
        $("#Casename").focus();
        return;
    }
    if (method1 == "请选择") {
        $("#adderrmsg").html("请选择请求方法");
        $("#method").focus();
        return;
    }
    if (host1 == "") {
        $("#adderrmsg").html("HOST不能为空");
        $("#host").focus();
        return;
    }
    if (URI1 == "") {
        $("#adderrmsg").html("URI不能为空");
        $("#URI").focus();
        return;
    }
    //提交
    $("#adderrmsg").html("&nbsp;");
    //customer_register_form_subFlag = 1;

    //var adddata ={
    //    projectname:projectname1,
    //    Intername:Intername1,
    //    Casename:Casename1,
    //    method:method1,
    //    host:host1,
    //    URI:URI1,
    //    Accept:Accept1,
    //    ContentType:ContentType1,
    //    islogin:islogin1,
    //    loginname:loginname1,
    //    ResultResponse:ResultResponse1,
    //    ResultResponseType:ResultResponseType1
    //
    //};

    //$.post("/savecase",
    //    adddata ,
    //    function(data,status){
    //        alert(adddata),
    //        alert("Data: " + data + "\nStatus: " + status);
    //    });

    var data = $("#addCase").serializeArray();

    $.ajax({
        type : "POST",
        url : "/savecase.do",
        data : data,
        dataType : "json",
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
        success : function(map) {
            //alert(map.message);
            if (map.status) {
                $("#addCase")[0].reset();
            }
        },
        error : function(info) {
           // alert("error!!!!!");
           // alert(info);
        }

    });


}

function addCasef(){

        layer.open({
            type: 2, //page层
            area: ['800px', '500px'],
            title: '新增测试用例',
            shade: 0.6, //遮罩透明度
            skin: 'layui-layer-lan',
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: -1, //0-6的动画形式，-1不开启
            content: '/jsp/addCase.jsp',
            end: function(){
                // 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
                if($("#addCase").length === 1){
                    $("#addCase").submit();
                }
            }
        });
}
function editCasef(){
    var data = $("#editCase").serializeArray();
    //alert( JSON.stringify(data))
    $.ajax({
        type : "POST",
        url : "/editcase.do",
        data : data,
        dataType : "json",
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
        success : function(map) {
         //   alert(map.message);
            //if (map.status) {
            //    $("#editCase")[0].reset();
            //}
        },
        error : function(info) {
            // alert("error!!!!!");
           //  alert(info);
        }

    });
}
function editCasequery(){
    //$("#edit",this).click(function(){//dealCheck为这个button控件ID
    //    var recordTime=$(this).row.item(3).valueOf();
    //   alert(recordTime)
    //});
    //$('#example2 tbody').on( 'click', 'button#edit', function () {
    //    var data = tables.row( $(this).parents('tr') ).data();
    //    alert(data);
    //    var fields = $("#add-form").serializeArray();
    //    jQuery.each( fields, function(i, field){
    //        //jquery根据name属性查找
    //        $(":input[name='"+field.name+"']").val(data[i]);
    //    });
    //    $(":input[name='mark']").val("edit");
    //    $("#modal-form").modal("show");//弹出框show
    //
    //});

}

//function serarchcase() {
//
//    $.ajax({
//        type: "POST",
//        url: "/searchcase.do",
//        dataType: "json",
//        contentType: 'application/json; charset=UTF-8',
//        success: function (data) {
//            $("#caselisttable").empty();
//            var strHTML = "";
//            $.each(data, function (index, val) {
//                // alert(val.id);
//                strHTML += "<tr>";
//                strHTML += "<td>" + val["id"] + "</td>";
//                strHTML += "<td>" + val["projectname"] + "</td>";
//                strHTML += "<td>" + val["intername"] + "</td>";
//                strHTML += "<td>" + val["host"] + "</td>";
//                strHTML += "<td>" + ("<input type='button' name='chkb' />") + "</td>";
//                strHTML += "<td>" + ($("#deletecase")) + "</td>"
//                strHTML += "</tr>";
//            });
//            $("#caselisttable").html(strHTML);
//        },
//        error: function (msg) {
//            //   alert(msg);
//        }
//
//    });
//}
//function serarchcase1() {
//    $('#example2').dataTable( {
//
//        "sAjaxSource": "/searchcase.do",
//        "bRetrieve": true,
//        //"sAjaxDataProp": "data"
//        "aoColumns": [
//            {
//            "mData": "id", "sClass": "myfont"
//        }, {
//            "mData": "host", "sClass": "myfont"
//        }, {
//            "mData": "id", "sClass": "myfont"
//        }, {
//            "mData": "id", "sClass": "myfont"
//        }, {
//            "mData": "host", "sClass": "myfont"
//        }, {
//            "mData": "host", "sClass": "myfont"
//        }, {
//            "mData": null,
//            "sClass": "center",
//            "bSortable": false,
//            "sDefaultContent": "<input type='button' class='EditSelected' align='left' value='编辑' />"
//        }
//        ]
//    });
//
//}
$(document).ready(function () {
      $('#example2').dataTable( {

            "sAjaxSource": "/searchcase.do",
            //"sAjaxDataProp": "data"
        "bAutoWidth": true, //自适应宽度
        "aaSorting": [[1, "asc"]],
        "sPaginationType": "full_numbers",
        "oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "对不起，查询不到相关数据！",
            "sEmptyTable": "表中无数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        },
        'columnDefs': [
            {
                'targets': 0,
                'checkboxes': {
                    'selectRow': true
                }
            }
        ],
        "aoColumns": [
            { "mRender": function (data, type, full) {
            sReturn = '<input type="checkbox" value="1" style="width:20px;" id="checkbox_id_all1" />';
            return sReturn;
        },
        "sClass": "checkboxes center"
    },
            {
        "mData": "id", "sClass": "center"
    }, {
        "mData": "projectname", "sClass": "center"
    }, {
        "mData": "intername", "sClass": "center"
    }, {
        "mData": "host", "sClass": "center"
    }, {
        "mData": "URI", "sClass": "center"
    }, {
        "mData": null,
        "sClass": "center edit-btn",
        "bSortable": false,
        "sDefaultContent": "<button type='button' name='editrow' id='editrow'  class='btn btn-primary' align='left' value='Edit'>Edit</button>"
    }
    ],
        "aoColumnDefs":[//设置列的属性，此处设置第一列不排序
            {"bSortable": false, "aTargets": [0]},
            { "class": "tn", "targets": [ 0 ] },
            { "sWidth": "50px", "aTargets": [0] },

        ]
    });
    //全选
    $('#checkbox_id_all').click( function () {
        $(":checkbox:not(#checkbox_id_all)").attr("checked", this.checked);
    } );
    //search foot 表格foot查询框
    $('#example2 tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" style="width:60px;" placeholder="'+title+'" />' );
    } );
    // DataTable
    var table = $('#example2').DataTable();

    // Apply the search 表格foot查询框
    table.columns().every( function () {
        var that = this;

        $( 'input', this.footer() ).on( 'keyup change', function () {
            if ( that.search() !== this.value ) {
                that
                    .search( this.value )
                    .draw();
            }
        } );
    } );
    //编辑用例弹出框
    $('#example2 tbody').on( 'click', 'button#editrow', function () {
        var data = table.row( $(this).parents('tr') ).data();
       // var caseid = getJson();
        var fields = $("#editCase").serializeArray();
        //alert(fields)
        layer.open({
            type: 1, //page层
            area: ['800px', '500px'],
            title: '编辑测试用例',
            skin: 'layui-layer-lan',
            shade: 0.6, //遮罩透明度
            moveType: 1, //拖拽风格，0是默认，1是传统拖动
            shift: -1, //0-6的动画形式，-1不开启
            content:$('#editCaseList'),// '/jsp/editCase.jsp', $('#id')
           //page : {dom:'#editCaseList'},
            end: function(){
                // 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
                if($("#editCaseList").length === 1){
                    $("#editCaseList").submit();
                }
            }
        });
        jQuery.each( fields, function(i, field){
            //jquery根据name属性查找
            //$(":input[host='"+field.host+"']").val(caseid);
            $("#caseNo").val(eval('data.'+"id"));
            $("#projectname").val(eval('data.'+"projectname"));
            $("#Intername").val(eval('data.'+"intername"));
            $("#Casename").val(eval('data.'+"casename"));
            $("#method").val(eval('data.'+"method"));
            $("#Accept").val(eval('data.'+"accept"));
            $("#ContentType").val(eval('data.'+"contentType"));
            $("#host").val(eval('data.'+"host"));
            $("#URI").val(eval('data.'+"URI"));
            $("#islogin").val(eval('data.'+"islogin"));
            $("#loginname").val(eval('data.'+"loginname"));
            $("#BeforeSql").val(eval('data.'+"beforeSql"));
            $("#body").val(eval('data.'+"body"));
            $("#AfterSQLType").val(eval('data.'+"afterSQLType"));
            $("#AfterSQL").val(eval('data.'+"afterSQL"));
            $("#ResultResponseType").val(eval('data.'+"resultResponseType"));
            $("#ResultResponse").val(eval('data.'+"resultResponse"));
        });
        //$("#editCase").modal("show");//弹出框show
        //function getJson(){
        //    var id=eval('data.'+"host");
        //    return id;
        //}
    } );
})









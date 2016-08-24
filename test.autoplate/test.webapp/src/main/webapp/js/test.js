///**
// * Created by zhanxiaobing on 2016/8/14.
// */
////"ajax": {
////    "url": "/searchcase.do",
////        //"dataSrc": "weather",
////        //"sAjaxDataProp": "weather",
////        "aoColumns": [{
////        "aaData": "id", "sClass": "myfont"
////    }, {
////        "mData": "host", "sClass": "myfont"
////    }, {
////        "aaData": "id", "sClass": "myfont"
////    }, {
////        "aaData": "id", "sClass": "myfont"
////    }, {
////        "aaData": "host", "sClass": "myfont"
////    }, {
////        "aaData": "host", "sClass": "myfont"
////    }, {
////        "aaData": null,
////        "sClass": "center",
////        "bSortable": false,
////        "sDefaultContent": "<input type='button' class='EditSelected' align='left' value='Edit' />"
////    }
////    ]
////}
//
//var data = [{"URI":"321","accept":"","afterSQL":"","afterSQLType":"","beforeSql":"","beforeSqlType":"","body":"","casename":"","contentType":"","createTime":null,"host":"32132","id":16,"intername":"321321","islogin":"","loginname":"","method":"","projectname":"3","resultResponse":"","resultResponseType":"","updateTime":null},{"URI":"21321","accept":"","afterSQL":"","afterSQLType":"","beforeSql":"","beforeSqlType":"","body":"","casename":"","contentType":"","createTime":null,"host":"3213","id":17,"intername":"2132","islogin":"","loginname":"","method":"","projectname":"2","resultResponse":"","resultResponseType":"","updateTime":null},{"URI":"ewqewq","accept":"","afterSQL":"","afterSQLType":"","beforeSql":"","beforeSqlType":"","body":"","casename":"","contentType":"","createTime":null,"host":"ewqewq","id":18,"intername":"ewqewq","islogin":"","loginname":"","method":"","projectname":"1","resultResponse":"","resultResponseType":"","updateTime":null}]
//
//
//
//$(document).ready(function() {
//
//    $('#example1').dataTable({
//        "aaData" :  data,
//        "aoColumns" : [ { "mData" : "id","sClass": "myfont"
//        },{
//            "mData" : "host","sClass": "myfont"
//        },{
//            "mData" : "intername","sClass": "myfont"
//        }, {
//            "mData" : "URI","sClass": "myfont"
//        }, {
//            "mData" : "projectname","sClass": "myfont"
//        }, {
//            "mData" : "islogin","sClass": "myfont"
//        },{
//            "mData" : null,
//            "sClass" : "center",
//            "bSortable": false,
//            "sDefaultContent" : "<input type='button' class='EditSelected' align='left' value='Edit' />" }
//        ]
//    });
//});
////$(document).ready(function () {
////     $("#example").dataTable({
////        "bProcessing": true,
////        "bServerSide": true,
////        "bSort": false,
////        "sAjaxSource": "/searchcase.do",//这是要请求json数据的url
////        "oLanguage": {
////            "sLengthMenu": "每页显示 _MENU_ 条记录",
////            "sZeroRecords": "对不起，查询不到任何相关数据",
////            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
////            "sInfoEmtpy": "找不到相关数据",
////            "sProcessing": "正在加载中...",
////            "sSearch": "搜索",
////            "sInfoEmpty": "显示 0 至 0 共 0 项",
////            "oPaginate": {"sFirst": "第一页", "sPrevious": "上一页 ", "sNext": "下一页 ", "sLast": "末页 "}
////        },
////        "aoColumns": [
////            {"mData": "id", "sClass": "center"},
////            {"mData": "host", "sClass": "center"},
////        ], "fnServerData": fnDataTablesPipeline
////    });
////});
////$(document).ready(function() {
////    $("#example").dataTable({
////        "bProcessing": false, // 是否显示取数据时的那个等待提示
////        "bServerSide": true,//这个用来指明是通过服务端来取数据
////        "sAjaxSource": "/searchcase.do",//这个是请求的地址
////        "fnServerData":retrieveData,
////        "aoColumns": [
////            {'aoData': 'id'},
////            {'aoData': 'host'},
////        ]
////    });
////
////});
////
////function retrieveData( sSource111,aoData111, fnCallback111) {
////    $.ajax({
////        url : sSource111,//这个就是请求地址对应sAjaxSource
////      //  data : {"aoData":JSON.stringify(aoData111)},//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
////        type : 'post',
////        dataType : 'json',
////        async : false,
////        success : function(data) {
////            $("#example").empty();
////            var strHTML = "";
////            $.each(data, function (index, val) {
////                // alert(val.id);
////                strHTML += "<tr>";
////                strHTML += "<td>" + val["id"] + "</td>";
////                strHTML += "<td>" + val["projectname"] + "</td>";
////                strHTML += "<td>" + val["intername"] + "</td>";
////                strHTML += "<td>" + val["host"] + "</td>";
////                strHTML += "<td>" + ("<input type='button' name='chkb' />") + "</td>";
////                strHTML += "<td>" + ($("#deletecase")) + "</td>"
////                strHTML += "</tr>";
////            });
////            $("#example").html(strHTML);
////        }
////    });
////}
//
////$(document).ready(function() {
////    $("#example").dataTable({
////
////        "bAutoWidth": false, //自适应宽度
////        "aaSorting": [[1, "asc"]],
////        "sPaginationType": "full_numbers",
////        "oLanguage": {
////            "sProcessing": "正在加载中......",
////            "sLengthMenu": "每页显示 _MENU_ 条记录",
////            "sZeroRecords": "对不起，查询不到相关数据！",
////            "sEmptyTable": "表中无数据存在！",
////            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
////            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
////            "sSearch": "搜索",
////            "oPaginate": {
////                "sFirst": "首页",
////                "sPrevious": "上一页",
////                "sNext": "下一页",
////                "sLast": "末页"
////            }
////        }, //多语言配置
////        "bProcessing": true,
////        "bDestroy": true,
////        "bServerSide": true,
////        "sAjaxSource": "/searchcase.do",
////        "aoColumns": [
////            {'mData': 'id'},
////            {'mDataProp': 'host'},
////        ]
////    });
////} );
//
////$(document).ready(function() {
////    $('#example2').dataTable({
////        "bProcessing": false, // 是否显示取数据时的那个等待提示
////        "sAjaxSource": "/searchcase.do",
////       // "data":aaData,
////       // "aaData" : aoData111,
////        "fnServerData": function ( sSource111,aaData, fnCallback) {
////            $.ajax({
////                url : sSource111,
////                //  data : {"aoData":JSON.stringify(aoData111)},
////                type : 'post',
////                dataType : 'json',
////               // data: aoData,
////                async : false,
////                success : function(aoData) {
////                    alert(JSON.stringify(aoData)),
////                     fnCallback(aoData);
////                }
////            });
////            return JSON.stringify(aoData);
////        },
////        "aoColumns" : [ { "aaData" : "id","sClass": "myfont"
////        },{
////            "aaData" : "host","sClass": "myfont"
////        },{
////            "aaData" : "id","sClass": "myfont"
////        }, {
////            "aaData" : "id","sClass": "myfont"
////        }, {
////            "aaData" : "createdUser","sClass": "myfont"
////        }, {
////            "aaData" : "lastUpDate","sClass": "myfont"
////        },{
////            "aaData" : null,
////            "sClass" : "center",
////            "bSortable": false,
////            "sDefaultContent" : "<input type='button' class='EditSelected' align='left' value='Edit' />" }
////        ]
////    });
////})
//
//
$(document).ready(function() {
    // Setup - add a text input to each footer cell
    $('#example tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
    } );

    // DataTable
    var table = $('#example').DataTable();

    // Apply the search
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
} );
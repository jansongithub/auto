/**
 * Created by zhanxiaobing on 2016/8/24.
 */
/**
 * Created by zhanxiaobing on 2016/8/3.
 */

$(document).ready(function () {
    $('#resultsearch').dataTable( {

        "sAjaxSource": "/searchcaseResutl.do",
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
        //'columnDefs': [
        //    {
        //        'targets': 0,
        //        'checkboxes': {
        //            'selectRow': true
        //        }
        //    }
        //],
        "aoColumns": [
            //{ "mRender": function (mData, type, full) {
            //    sReturn = '<input type="checkbox" value="' + mData +'" style="width:20px;" class="docaseid_all" />';
            //    return sReturn;
            //},
            //    "mData": "id",
            //    "sClass": "checkboxes center"
            //},
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
                "mData": "Result_Status", "sClass": "center"
            }, {
                "mData": null,
                "sClass": "center edit-btn",
                "bSortable": false,
                "sDefaultContent": "<button type='button' name='docase' id='docase'  class='btn btn-primary' align='left' value=''>执行</button>"
            }
        ]
        //"aoColumnDefs":[//设置列的属性，此处设置第一列不排序
        //    {"bSortable": false, "aTargets": [0]},
        //    { "class": "tn", "targets": [ 0 ] },
        //    { "sWidth": "50px", "aTargets": [0] },
        //
        //]
    });
    ////全选
    //$('#checkbox_docaseid_all').click( function () {
    //    //$(":checkbox:not(#checkbox_docaseid_all)").attr("checked", this.checked);
    //    if(this.checked){
    //        $("#CaseDo :checkbox").attr("checked", true);
    //    }else{
    //        $("#CaseDo :checkbox").attr("checked", false);
    //    }
    //} );


    //search foot 表格foot查询框
    $('#CaseDo tfoot th').each( function () {
        var title = $(this).text();
        $(this).html( '<input type="text" style="width:60px;" placeholder="'+title+'" />' );
    } );
    // DataTable
    var table = $('#CaseDo').DataTable();

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

    //执行用例
    $('#CaseDo tbody').on( 'click', 'button#docase', function () {
        var data = table.row( $(this).parents('tr') ).data();
        var caseid = eval('data.'+"id");
        alert(caseid)
        var casedata = {"id":caseid};

        $.ajax({
            type: "POST",
            url: "/docaseid.do",
            data: casedata,
            dataType: "json",
            contentType: 'application/x-www-form-urlencoded; charset=UTF-8'
        });
        layer.open({
            type: 1,
            area: ['300px', '100px'],
            skin: 'layui-layer-lan', //样式类名
            closeBtn: 0, //不显示关闭按钮
            shift: 2,
            shadeClose: true, //开启遮罩关闭
            content: '执行开始，刷新查看结果',
            end: function(){
                // 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
                if($("#caseDolist").length === 1){
                    $("#caseDolist").submit();
                }
            }
        });
    } );
})

////批量执行用例
//function doallCase() {
//    //var arrCaseid = [];
//    var arrCaseid = new Array();
//    //var arrChk=$("input[class=checkbox_docaseid_all1]:checked");
//    //alert(arrChk.length)
//
//    $(".docaseid_all").each(function(i) {
//        if (this.checked == true) {
//            //arrCaseid[i] = $(this).val();
//            arrCaseid.push($(this).val());
//        }
//    });
//    var vals = arrCaseid.join(',');//数组转换以逗号隔开的字符串
//    alert(vals);
//
//    // var data= JSON.stringify(arrCaseid);
//
//    $.ajax({
//        type: "POST",
//        url: "/docaseid.do",
//        data: {'id':vals},
//        dataType: "json",
//        contentType: 'application/x-www-form-urlencoded; charset=UTF-8'
//    });
//    layer.open({
//        type: 1,
//        area: ['300px', '100px'],
//        skin: 'layui-layer-lan', //样式类名
//        closeBtn: 0, //不显示关闭按钮
//        shift: 2,
//        shadeClose: true, //开启遮罩关闭
//        content: '执行开始，刷新查看结果',
//        end: function(){
//            // 如果是通过单击关闭按钮关闭弹出层，父画面没有此表单
//            if($("#caseDolist").length === 1){
//                $("#caseDolist").submit();
//            }
//        }
//    });
//}








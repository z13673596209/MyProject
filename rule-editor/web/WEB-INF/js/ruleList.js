$(document).ready(
    function () {
        var rules = new Array();
        lastpath1 = "22";
        lastpath2 = "";
        var rule1 = {
            name: null,
            text: null,
            location: null
        };

        var post = JSON.stringify(rule1);
        $
            .ajax({
                url: "CreateList",
                dataType: "json",
                method: "POST",
                data: post,
                contentType: "application/json; charset=utf-8",
                error: function (json, textStatus, errorMessage) {
                    alert("加载失败，原因为：" + errorMessage);
                },
                success: function (json) {
                    rules = json.rules;
                    var length = rules.length
                    for (i = 0; i < length; i++) {
                        var rule = new Object();
                        rule.name = rules[i].name;
                        if (rule.name == "其他") {
                            var name;
                            name = rules[length - 1].name;
                            rules[length - 1].name = rule.name;
                            rule.name = name;
                        } else {
                        }
                        if (rule.name != "DroolsProject"
                            && rule.name != "Logs") {
                            var node = $("<li></li>").append(
                                $("<a></a>").attr("href", "###")
                                    .text(rule.name));
                            $("#1").append(node);
                        } else {
                        }

                    }
                }

            })

    })

$("#1").delegate(
    "a",
    "click",
    function () {
        path1 = $(this).text();
        var rule2 = {
            name: null,
            text: null,
            location: path1
        };

        var div2 = $("<div></div>").attr("id", "2");
        var div3 = $("<div></div>").attr("id", "3");
        var div4 = $("<div></div>").attr("id", "4");
        $("#4").replaceWith(div4);
        var post = JSON.stringify(rule2);
        $
            .ajax({
                url: "CreateList",
                dataType: "json",
                method: "POST",
                data: post,
                contentType: "application/json; charset=utf-8",
                error: function (json, textStatus, errorMessage) {
                    alert("加载失败，原因为：" + errorMessage);
                },
                success: function (json) {
                    rules = json.rules;
                    var length = rules.length;
                    for (i = 0; i < length; i++) {
                        var rule = new Object();
                        rule.name = rules[i].name;

                        if (rule.name.indexOf(".") == -1) {
                            var node = $("<a></a>").attr("href", "###")
                                .text(rule.name).attr("class",
                                    "list-group-item");
                            node.append($("<img></img>").attr("src",
                                "lib/picture/folder.png"));
                            $(div2).append(node);
                        } else {
                            var node = $("<a></a>").attr("href", "###")
                                .text(rule.name).attr("class",
                                    "list-group-item");
                            $(div3).append(node);
                        }

                    }
                    $("#2").replaceWith(div2);
                    $("#3").replaceWith(div3);
                }

            })
    })

$(document).on(
    "click",
    "#2 a",
    (function () {

        lasttext = $(this).text();
        path1 = path1 + "/" + $(this).text();
        var rule3 = {
            name: null,
            text: null,
            location: path1
        };
        var rtn = $("<a></a>").attr("href", "###").text("...(上层目录)").attr(
            "class", "list-group-item").attr("id", "return");
        var div2 = $("<div></div>").attr("id", "2");
        var div3 = $("<div></div>").attr("id", "3");
        var div4 = $("<div></div>").attr("id", "4");
        div4.append(rtn);

        var post = JSON.stringify(rule3);
        $
            .ajax({
                url: "CreateList",
                dataType: "json",
                method: "POST",
                data: post,
                contentType: "application/json; charset=utf-8",
                error: function (json, textStatus, errorMessage) {
                    alert("加载失败，原因为：" + errorMessage);
                },
                success: function (json) {
                    rules = json.rules;
                    if (rules!=null){
                    var length = rules.length;


                        for (i = 0; i < length; i++) {
                            var rule = new Object();
                            rule.name = rules[i].name;
                            if (rule.name.indexOf(".") == -1) {
                                var node = $("<a></a>").attr("href", "###")
                                    .text(rule.name).attr("class",
                                        "list-group-item");
                                node.append($("<img></img>").attr("src",
                                    "lib/picture/folder.png"));
                                $(div2).append(node);
                            } else {
                                var node = $("<a></a>").attr("href", "###")
                                    .text(rule.name).attr("class",
                                        "list-group-item");
                                div3.append(node);
                            }
                        }
                        $("#2").replaceWith(div2);
                        $("#3").replaceWith(div3);
                        $("#4").replaceWith(div4);

                    } else {
                        $("#2").replaceWith(div2);
                        $("#3").replaceWith(div3);
                        $("#4").replaceWith(div4);

                        // path1 = path1.substring(0, path1.lastIndexOf("/"));
                    }
                }

            })

    }))
$(document).on("click", "#3 a", (function () {

    path2 = path1 + "/" + $(this).text();
    var rule = {
        name: null,
        text: null,
        location: path2
    }
    post = JSON.stringify(rule);
    $.ajax({
        url: "ReturnText",
        dataType: "json",
        method: "POST",
        data: post,
        contentType: "application/json; charset=utf-8",
        error: function (json, textStatus, errorMessage) {
            alert("加载失败，原因为：" + errorMessage);
        },
        success: function (json) {
            rules = json.rules;
            var rule = new Object();
            rule.text = rules[0].text;
            text = rule.text;
            $("#textarea").html(text);
        }

    })

}))

$(document).on("click", "#btnCreateRule", (function createRule() {
    if (confirm("确定是否生成规则？")) {
        var ttxt = $("#textarea").val();
        var rule = {
            name: null,
            text: ttxt,
            location: path2
        };

        var post = JSON.stringify(rule);
        $.ajax({
            url: "CreateRule",
            dataType: "json",
            method: "POST",
            data: post,
            async: false,
            contentType: "application/json; charset=utf-8",
            error: function (json, textStatus, errorMessage) {
                alert("连接失败，原因为：" + errorMessage);
            },
            success: function (json) {
                if (json.result == "success")
                    alert("生成成功！");

                if (json.result == "false")
                    alert("生成失败");
            }

        })
    } else {
    }
}))

$("#1").delegate("li", "click", function () {
    $("li").attr("class", "");
    $("li").css("border-bottom", "");

    $(this).css("border-bottom", "solid #F00");
    $(this).attr("class", "active");

})

$("#1").delegate("a", "mouseenter", function () {

    $(this).css("border-bottom", "solid #F00");

    $("#1").delegate("a", "mouseleave", function () {
        $(this).css("border-bottom", "");
    })
})

$(document).on(
    "click",
    "#4 a",
    function () {
        if (path1.indexOf("/") != -1) {
            path1 = path1.substring(0, path1.lastIndexOf("/"));
            var rule3 = {
                name: null,
                text: null,
                location: path1
            };
            var rtn = $("<a></a>").attr("href", "###").text("...(上层目录)")
                .attr("class", "list-group-item").attr("id", "return");
            var div2 = $("<div></div>").attr("id", "2");
            var div3 = $("<div></div>").attr("id", "3");
            var div4 = $("<div></div>").attr("id", "4");
            div4.append(rtn);

            var post = JSON.stringify(rule3);
            $.ajax({
                url: "CreateList",
                dataType: "json",
                method: "POST",
                data: post,
                contentType: "application/json; charset=utf-8",
                error: function (json, textStatus, errorMessage) {
                    alert("加载失败，原因为：" + errorMessage);
                },
                success: function (json) {
                    rules = json.rules;
                    var length = rules.length;
                    for (i = 0; i < length; i++) {
                        var rule = new Object();
                        rule.name = rules[i].name;
                        if (rule.name.indexOf(".") == -1) {
                            var node = $("<a></a>").attr("href", "###")
                                .text(rule.name).attr("class",
                                    "list-group-item");
                            node.append($("<img></img>").attr("src",
                                "lib/picture/folder.png"));
                            $(div2).append(node);
                        } else {
                            var node = $("<a></a>").attr("href", "###")
                                .text(rule.name).attr("class",
                                    "list-group-item");
                            div3.append(node);
                        }
                    }
                    $("#2").replaceWith(div2);
                    $("#3").replaceWith(div3);
                    $("#4").replaceWith(div4);

                }

            })
        } else {
            var div4 = $("<div></div>").attr("id", "4");
            $("#4").replaceWith(div4);
        }

    })

$(document).ready(function() {

    // WIZARD - PAGER
    $('#campaignWizard').bootstrapWizard({
        onTabShow: function(tab, navigation, index) {
            var $total = navigation.find('li').length;
            var $current = index + 1;
            // If it's the last tab then hide the last button and show the finish instead
            if ($current >= $total) {
                $('#campaignWizard').find('.pager .next').hide();
                $('#campaignWizard').find('.pager .finish').show();
                $('#campaignWizard').find('.pager .finish').removeClass('disabled');
            } else {
                $('#campaignWizard').find('.pager .next').show();
                $('#campaignWizard').find('.pager .finish').hide();
            }
            var li = navigation.find('li.active');
            var btnNext = $('#campaignWizard').find('.pager .next').find('button');
            var btnPrev = $('#campaignWizard').find('.pager .previous').find('button');
            // remove fontAwesome icon classes
            function removeIcons(btn) {
                btn.removeClass(function(index, css) {
                    return (css.match(/(^|\s)fal-\S+/g) || []).join(' ');
                });
            }
            if ($current > 1 && $current < $total) {
                var nextIcon = li.next().find('.fal');
                //var nextIconClass = nextIcon.attr('class').match(/fal-[\w-]*/).join();
                removeIcons(btnNext);
                //btnNext.addClass(nextIconClass + ' btn-animated from-left fal');
                var prevIcon = li.prev().find('.fal');
                //var prevIconClass = prevIcon.attr('class').match(/fal-[\w-]*/).join();
                removeIcons(btnPrev);
            //    btnPrev.addClass(prevIconClass + ' btn-animated from-left fal');
            } else if ($current == 1) {
                // remove classes needed for button animations from previous button
                btnPrev.removeClass('btn-animated from-left fal');
                removeIcons(btnPrev);
            } else {
                // remove classes needed for button animations from next button
                btnNext.removeClass('btn-animated from-left fal');
                removeIcons(btnNext);
            }
        }
    });

    //TogglerBar

    $( ".togglerBar" ).click(function() {
        $( this ).toggleClass( "toMin" );
        $(".togglerBar .fas").toggleClass( "fa-chevron-double-left" );
        $(".togglerBar .fas").toggleClass( "fa-chevron-double-right" );
        $("#campaignWizard").toggleClass( "toMin" );
        $("#previewSide").toggleClass( "toMax" );
        $(window).resize();
        console.log("clicked");
    });


    //ChangeAspectRatioOnClick-AdPreview
    $( "#btn-ar-2-1" ).click(function() {
        $('#adPreview').removeClass();
        $('#adPreview').addClass('ar-2-1');
    });

    $("#btn-ar-1-1").click(function() {
        $('#adPreview').removeClass();
        $('#adPreview').addClass('ar-1-1');
    });

    $("#btn-ar-2-3").click(function() {
        $('#adPreview').removeClass();
        $('#adPreview').addClass('ar-2-3');
    });


    // CopyCodeButton
    document.getElementById("copyButton").addEventListener("click", function() {
        copyToClipboard(document.getElementById("finalCode"));
    });

    function copyToClipboard(elem) {
    	  // create hidden text element, if it doesn't already exist
        var targetId = "_hiddenCopyText_";
        var isInput = elem.tagName === "INPUT" || elem.tagName === "TEXTAREA";
        var origSelectionStart, origSelectionEnd;
        if (isInput) {
            // can just use the original source element for the selection and copy
            target = elem;
            origSelectionStart = elem.selectionStart;
            origSelectionEnd = elem.selectionEnd;
        } else {
            // must use a temporary form element for the selection and copy
            target = document.getElementById(targetId);
            if (!target) {
                var target = document.createElement("textarea");
                target.style.position = "absolute";
                target.style.left = "-9999px";
                target.style.top = "0";
                target.id = targetId;
                document.body.appendChild(target);
            }
            target.textContent = elem.textContent;
        }
        // select the content
        var currentFocus = document.activeElement;
        target.focus();
        target.setSelectionRange(0, target.value.length);

        // copy the selection
        var succeed;
        try {
        	  succeed = document.execCommand("copy");
        } catch(e) {
            succeed = false;
        }
        // restore original focus
        if (currentFocus && typeof currentFocus.focus === "function") {
            currentFocus.focus();
        }

        if (isInput) {
            // restore prior selection
            elem.setSelectionRange(origSelectionStart, origSelectionEnd);
        } else {
            // clear temporary content
            target.textContent = "";
        }
        return succeed;
    }

    //Dropzone
    $("div#uploadTemplateAd").dropzone({ url: "/file/post" });

    // Initialize datatable with ability to add rows dynamically
    var initTableWithDynamicRows = function() {
        var table = $('#table-rules');


        var settings = {
            "sDom": "<t><'row'<p i>>",
            "destroy": true,
            "scrollCollapse": true,
            "oLanguage": {
                "sLengthMenu": "_MENU_ ",
                "sInfo": "Showing <b>_START_ to _END_</b> of _TOTAL_ entries"
            },
            "iDisplayLength": 5
        };


        table.dataTable(settings);

        $('#edit-rule-01').click(function() {
            $('#addNewAppModal').modal('show');
        });

        $('#add-app').click(function() {
            table.dataTable().fnAddData([
                $("#appName").val(),
                $("#appDescription").val(),
                $("#appPrice").val(),
                $("#appNotes").val()
            ]);
            $('#addNewAppModal').modal('hide');

        });
    }

});

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    var activeUrl = window.location.href;
    var activeId = activeUrl.substring(activeUrl.lastIndexOf('id='), (activeUrl.lastIndexOf('id=') + 4));
    activeId = activeId.substring(3, 4);
    if (activeId === activeUrl) {
        activeId = 0;
    };
    
    $('#' + activeId).addClass("selected");

    $('.selectable').click(function () {
        var id = $(this).attr('id');
        $('#hotelForm').attr('action', "/HotelLabWeb/hotelweb?type=view&hotel_id=" + id + "&arraySpace=" + $(this).attr("arraySpace"));
        $('#hotelForm').submit();
    });

    $('.selectable').mouseover(function () {
        $(this).css("background-color", "#78B220");
    });

    $('.selectable').mouseout(function () {
        if ($(this).hasClass("selected")) {

        } else {
            $(this).css("background-color", "#ADFF2F");
        }
    });

    $('#insertBtn').click(function () {

        $('#hotelForm').attr('action', "/HotelLabWeb/hotelweb?type=create&hotel_id=0");

        if ($('#name').val().length > 0 && $('#address').val().length > 0 && $('#city').val().length > 0 &&
                $('#state').val().length > 0 && $('#postal').val().length > 0) {
            $('#hotelForm').submit();
        } else {
            $('#error').removeClass('hidden');
            $('#error').text("All fields are required except Notes.");
        }

    });

    $('#viewBtn').click(function () {
        $('#hotelForm').attr('action', "/HotelLabWeb/hotelweb?type=normal&hotel_id=0");
        $('#hotelForm').submit();
    });

    $('#updateBtn').click(function () {
        var url = window.location.href;
        var type = url.substring(url.indexOf('=') + 1, url.indexOf('&'));
        var id = url.substring(url.lastIndexOf('id='), (url.lastIndexOf('id=') + 4));
        id = id.substring(3, 4);
        if (type === "view" && !$('#hotelForm').hasClass('cleared')) {
            $('#hotelForm').attr('action', "/HotelLabWeb/hotelweb?type=update&hotel_id=" + id + "&arraySpace=" + $('#' + id).attr("arraySpace"));
            $('#hotelForm').submit();
        } else {
            $('#error').removeClass('hidden');
            $('#error').text("Please select a hotel to update.");
        }
    });

    $('#deleteBtn').click(function () {
        var url = window.location.href;
        var type = url.substring(url.indexOf('=') + 1, url.indexOf('&'));
        var id = url.substring(url.lastIndexOf('id='), (url.lastIndexOf('id=') + 4));
        id = id.substring(3, 4);
        if ((type === "view" || type === "update") && !$('#hotelForm').hasClass('cleared')) {
            $('#hotelForm').attr('action', "/HotelLabWeb/hotelweb?type=delete&hotel_id=" + id + "&arraySpace=" + $('#' + id).attr("arraySpace"));
            $('#hotelForm').submit();
        } else {
            $('#error').removeClass('hidden');
            $('#error').text("Please select a hotel to delete.");
        }
    });

    $('#clearBtn').click(function () {
        $('#hotelForm').addClass('cleared');
        $('.selected').removeClass('selected');
        $('.selectable').css('background-color', '#ADFF2F');
        $('#name').val('');
        $('#address').val('');
        $('#city').val('');
        $('#state').val('');
        $('#postal').val('');
        $('#notes').val('');
    });
    
});
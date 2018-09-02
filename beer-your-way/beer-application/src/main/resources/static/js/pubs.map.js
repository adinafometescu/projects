function initMap() {
    $.get( "/location", function( data ) {
        var center = {lat: data.lat, lng: data.lng};
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: center
        });
        var marker = new google.maps.Marker({
             position: center,
             map: map
        });
        initPubs(data, map);
    });
}

function initPubs(location, map){
    $.get( "/search/pubs?distance=5&lat=" + location.lat + "&lng=" + location.lng, function( pubs ) {
        if(pubs == null){
            return;
        }
        for (var i = 0; i < pubs.length; i++) {
            var pub = pubs[i];
            var marker = new google.maps.Marker({
                position: {lat: pub.location.lat, lng: pub.location.lon},
                map: map
                });
            }
        });
}
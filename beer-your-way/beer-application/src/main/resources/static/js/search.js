function initPriceRange() {
    $.get( "/beer/price/range", function( data ) {
        $("#priceMin").val(data.priceMin);
        $("#priceMin").attr('min',data.priceMin);
        $("#priceMin").attr('max',data.priceMax);

        $("#priceMax").attr('min',data.priceMin);
        $("#priceMax").attr('max',data.priceMax);
        $("#priceMax").val(data.priceMax);
    });
}

$(function() {
   initPriceRange();
});
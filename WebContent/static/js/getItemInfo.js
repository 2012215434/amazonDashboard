function queryItem(){
	var ASIN = document.getElementById('ASIN').value;
	$.ajax({
  		url: "http://localhost:8080/dashBoard1/api/getItemInfo",
  		data: {
    		ASIN: ASIN
  		},
  		
  		success: function( result ) {
  			alert(result);
    		var json = JSON.parse(result);
    		alert(json['price']);
    		$('#items').append('<tr>'+
    			'<td>'+ json['productImage'] +'</td>'+
    			'<td>'+ json['title'] +'</td>'+
    			'<td>'+ json['asin'] +'</td>'+
    			'<td>'+ json['category'] +'</td>'+
    			'<td>'+ json['subCategory'] +'</td>'+
    			'<td>'+ json['salesRank'] +'</td>'+
    			'<td>'+ json['buyCostUnit'] +'</td>'+
    			'<td>'+ json['buyCostCasePrice'] +'</td>'+
    			'<td>'+ json['amazonFbaFee'] +'</td>'+
    			'<td>'+ json['roi'] +'</td>'+
    			'<td>'+ json["buyBoxPrice"] +'</td>'+
    			'<td>'+ json['lowFbaPrice'] +'</td>'+
    			'<td>'+ json['vender'] +'</td>'+
    			'</tr>');
 		}
	});
}


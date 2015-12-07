var sports;

var prefix = "/chart/";

var title;

var restGetResultsBySport = function() {
	// var filter = document.getElementById("filterSelect")
	// filter.style.visibility = 'visible'

	$.ajax({
		type : 'GET',
		url : prefix + "resultsbysport",
		dataType : 'json',
		async : true,
		data : JSON.stringify(""),
		success : function(result) {
			sports = new Array();
			var i = 0;
			while (result[i]) {
				sports[i] = new Array(4)
				sports[i][0] = result[i][0].name;
				sports[i][1] = result[i][0].count;
				sports[i][2] = '#a3a3f5';
				sports[i][3] = result[i][0].count;
				i++;
			}
			sports.unshift([ "Sport", "Sportolók száma", {
				role : 'style'
			}, {
				role : 'annotation'
			} ]);

			title = 'Sportok népszerűsége sportolók szerint';
			drawChart();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.status + " " + jqXHR.responseText);
		}
	});
}

// Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {
	'packages' : [ 'corechart' ]
});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

	// Create the data table.
	var data = google.visualization.arrayToDataTable(sports)

	// Set chart options
	var options = {
		'title' : title,
		'width' : 1000,
		'height' : 500,
		'color' : 'orange',
		'backgroundColor' : '#e1e1ea',
		'bar' : {
			groupWidth : '55%'
		},
		'vAxis' : {
			title : 'Sportok'
		},
		'hAxis' : {
			title : 'Sportolók száma',
			viewWindow : {
				min : 0
			}
		}
	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.BarChart(document
			.getElementById('chart_div'));
	chart.draw(data, options);

}

function drawPieChart() {
	// Create the data table.
	var data = google.visualization.arrayToDataTable(sports)

	// Set chart options
	var options = {
		'title' : title,
		'width' : 1000,
		'height' : 500,
		'color' : 'orange',
		is3D : true,
		'backgroundColor' : '#e1e1ea'

	};

	// Instantiate and draw our chart, passing in some options.
	var chart = new google.visualization.PieChart(document
			.getElementById('chart_div'));
	chart.draw(data, options);
}

function showSportResult(){
	var sportSelect = document.getElementById('sportFilter');
	var clubSelect = document.getElementById('clubFilter');
	
	sportSelect.style.visibility= 'visible';
	clubSelect.style.visibility= 'hidden';
	restGetResultsBySportId();
}

function showClubResult(){
	var sportSelect = document.getElementById('sportFilter');
	var clubSelect = document.getElementById('clubFilter');
	
	sportSelect.style.visibility= 'hidden';
	clubSelect.style.visibility= 'visible';
	restGetResultsByClubId();
}


function restGetResultsByClubId() {
	var elem = document.getElementById('allClub');
	var emptyLabel = document.getElementById('emptyLabel');
	var chart = document.getElementById('chart_div');
	
	$.ajax({
		type : 'PUT',
		url : prefix + "resultsbyclub",
		dataType : 'json',
		data : JSON.stringify(elem.value),
		async : true,
		success : function(result) {
			if (!$.isEmptyObject(result)) {
				emptyLabel.style.visibility= 'hidden';
				chart.style.visibility= 'visible';
				sports = new Array()
				var i = 0;
				while (result[i]) {
					sports[i] = new Array(3)
					sports[i][0] = result[i][0].name;
					sports[i][1] = result[i][0].count;
					sports[i][2] = 'orange';
					i++
				}
				sports.unshift([ "Sport", "Klubok száma", {
					role : 'style'
				} ]);

				title = 'Sportok népszerűsége klubok szerint';
				drawChart()
			}
			else {
				emptyLabel.style.visibility= 'visible';
				chart.style.visibility= 'hidden';
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.status + " " + jqXHR.responseText);
		}
	});

}

function restGetResultsBySportId() {
	var elem = document.getElementById('allSport');
	var emptyLabel = document.getElementById('emptyLabel');
	var chart = document.getElementById('chart_div');
	
	$.ajax({
		type : 'PUT',
		url : prefix + "resultsbysport",
		dataType : 'json',
		data : JSON.stringify(elem.value),
		async : true,
		success : function(result) {
			if (!$.isEmptyObject(result)) {
				emptyLabel.style.visibility= 'hidden';
				chart.style.visibility= 'visible';
				sports = new Array()
				var i = 0;
				while (result[i]) {
					sports[i] = new Array(3)
					sports[i][0] = result[i][0].name;
					sports[i][1] = result[i][0].count;
					sports[i][2] = 'orange';
					i++
				}
				sports.unshift([ "Sport", "Klubok száma", {
					role : 'style'
				} ]);

				title = 'Sportok népszerűsége klubok szerint';
				drawChart()
			}
			else {
				emptyLabel.style.visibility= 'visible';
				chart.style.visibility= 'hidden';
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.status + " " + jqXHR.responseText);
		}
	});

}

$(document).ready(function() {
	showSportResult();
	restGetResultsBySportId();
})
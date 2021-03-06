var sports;

var prefix = "/chart/";

var title;

var restGetSupp = function() {
    $.ajax({
        type: 'GET',
        url: prefix + "supplementpopularity",
        dataType: 'json',
        async: true,
        success: function(result) {
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
            sports.unshift(["Táplálékkiegészítők", "Sportolók száma", { role: 'style'}, { role: 'annotation' } ]);

            title = 'Táplálékkiegészítők népszerűsége sportolók szerint';
            drawChart();
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
}



// Load the Visualization API and the piechart package.
google.load('visualization', '1.0', {
    'packages': ['corechart']
});

// Set a callback to run when the Google Visualization API is loaded.
google.setOnLoadCallback(drawChart);
restGetSupp();
// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {

    // Create the data table.
    var data = google.visualization.arrayToDataTable(sports)

    // Set chart options
    var options = {
        'title': title,
        'width': 1200,
        'height': 500,
        'color': 'orange',
        'backgroundColor': '#e1e1ea',
        'bar': { groupWidth: '55%' },
        'vAxis': {title: 'Táplálékkiegészítők'},
        'hAxis': {title: 'Sportolók száma' }

    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
    chart.draw(data, options);

}


function drawPieChart() {
    // Create the data table.
    var data = google.visualization.arrayToDataTable(sports)

    // Set chart options
    var options = {
        'title': title,
        'width': 1000,
        'height': 500,
        'color': 'orange',
        is3D: true,
        'backgroundColor': '#e1e1ea'

    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    chart.draw(data, options);
}

function restGetSuppByClub() {
    $.ajax({
        type: 'GET',
        url: prefix + "supplementpopularitybyclub",
        dataType: 'json',
        async: true,
        success: function(result) {
            sports = new Array()
            var i = 0;
            while (result[i]) {
                sports[i] = new Array(3)
                sports[i][0] = result[i][0].name;
                sports[i][1] = result[i][0].count;
                sports[i][2] = 'orange';
                i++
            }
            sports.unshift(["Sport", "Klubok száma", {
                role: 'style'
            }]);

            title = 'Sportok népszerűsége klubok szerint';
            drawPieChart()
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
}
    
    
    
    function restGetSuppBrandByPeople() {
            $.ajax({
                type: 'GET',
                url: prefix + "supplementbrandpopularitybypeople",
                dataType: 'json',
                async: true,
                success: function(result) {
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
                    sports.unshift(["Táplálékkiegészítők", "Sportolók száma", { role: 'style'}, { role: 'annotation' } ]);

                    title = 'Táplálékkiegészítők népszerűsége sportolók szerint';
                    drawChart();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.status + " " + jqXHR.responseText);
                }
            });
    }


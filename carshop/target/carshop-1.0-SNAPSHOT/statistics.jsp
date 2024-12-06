<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thống kê</title>
        <link rel="stylesheet" href="css/statistics.css" />
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>
    <body style="margin: 0; padding: 0">
        <div class="container" style="display: flex; max-width: 100%">
            <div class="menu" style="width: 18%">
                <jsp:include page="menu.jsp" />
            </div>

            <div class="content" style="width: 82%; display: flex; flex-wrap: wrap ;justify-content: space-around;">
                <div class="card" style="margin: 20px 0;">
                    <h2>Hãng xe</h2>
                    <h2>${totalCompany}</h2>
                </div>
                <div class="card" style="margin: 20px 0;">
                    <h2>Tổng vốn đầu tư</h2>
                    <h2>${totalPrice}</h2>
                </div>
                <div class="card" style="margin: 20px 0;">
                    <h2>Số xe đang quản lý</h2>
                    <h2>${totalCar}</h2>
                </div>

                <!-- Biểu đồ -->
                <div class="chart-container" style="height: 450px; align-items: center">
                    <div class="vehicleByBrandChart" style="margin: 40px">
                        <canvas id="myChartBar" style="width: 650px;"></canvas>
                    </div>
                    <div class="vehicleConditionPieChart" style="margin: 40px">
                        <canvas id="myChartPie"></canvas>
                    </div>
                </div>
            </div>
        </div>

        <!-- biểu đồ tròn -->
        <script>
            var chartLabels = ['xe mới', 'xe đã dùng'];
            var chartData = ${data};

            var ctx = document.getElementById('myChartPie').getContext('2d');
            var myPieChart = new Chart(ctx, {
                type: 'pie', // Chọn loại biểu đồ là tròn
                data: {
                    labels: chartLabels,
                    datasets: [{
                            label: 'Thống kê',
                            data: chartData,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top'
                        },
                        tooltip: {
                            callbacks: {
                                label: function (tooltipItem) {
                                    return tooltipItem.label + ': ' + tooltipItem.raw; // Hiển thị số liệu bên cạnh nhãn
                                }
                            }
                        }
                    }
                }
            });
        </script>

        <!-- biểu đồ cột -->
        <script>
            var chartLabels = JSON.parse('${nameCompany}');
            var chartData = JSON.parse('${dataCompany}');

            var ctxBrand = document.getElementById("myChartBar").getContext("2d");
            var vehicleByBrandChart = new Chart(ctxBrand, {
                type: "bar",
                data: {
                    labels: chartLabels,
                    datasets: [
                        {
                            type: "bar",
                            label: "Số lượng xe",
                            data: chartData,
                            backgroundColor: "rgba(52, 152, 219, 0.5)",
                            borderColor: "#3498db",
                            borderWidth: 1,
                            borderRadius: 8,
                        },
                    ],
                },
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true,
                            grid: {
                                color: "#bdc3c7",
                                borderDash: [5, 5],
                            },
                        },
                        x: {
                            grid: {
                                display: false,
                            },
                        },
                    },
                    plugins: {
                        legend: {
                            position: "top",
                        },
                    },
                },
            });
        </script>
    </body>
</html>

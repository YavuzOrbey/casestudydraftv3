<%@include file="../inc/head.jsp" %>
    <title>Calendar</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <style>
        body{

        }

        .main-area{
            background: #6D6262;
            padding: 10px;
        }
        .calendar-header{
            height: 50px;
            background: #D83E3E;
            text-align: center;
            color: white;
            border-top-left-radius: 10px;
            border-top-right-radius: 10px;
        }
        .col-md{
            background: white;
            border: 1px solid black;
        }
        .out-of-month{
            background-color: gray;
        }
    </style>
</head>
<body>
  <%@include file="../inc/nav.jsp" %>
    <div class="container">
        <div class="calendar-header">
            <i class="fas fa-arrow-circle-left" style="float: left; "></i>
            <h4>March 2021</h4>
            <i class="fas fa-arrow-circle-right" style="float: right;"></i>
        </div>
        <div class="main-area">
            <div class='container'>
            <% boolean start=false; %>
			<c:forEach begin="1" end="${numWeeks}" var="weekNumber" varStatus="row">
				<div class='row'>
				<c:forEach begin="1" end="7" var="dayOfWeek" varStatus="column">
	                <div class="col-12 col-md m-1 ${(dayOfWeek>=firstDay || weekNumber > 1) && (weekNumber < numWeeks  || dayOfWeek<=lastDay) ? "": "out-of-month"}">
	                    <h4>${weekNumber*dayOfWeek}</h4>
	                </div>
	            </c:forEach>
				</div>
            </c:forEach>
        </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</body>
</html>
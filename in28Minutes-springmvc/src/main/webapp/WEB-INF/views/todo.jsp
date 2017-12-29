<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
       <form:form method="post" modelAttribute="todo">
           <form:hidden path="id" />
           <fieldset class="form-group">
               <form:label path="desc">Description</form:label>
               <form:input path="desc" type="text" class="form-control" required="required" />
               <form:errors path="desc" cssClass="text-warning" />
           </fieldset>
           <fieldset class="form-group">
               <form:label path="targetDate">Target Date</form:label>
               <form:input path="targetDate" type="text" class="form-control" required="required" />
               <form:errors path="targetDate" cssClass="text-warning" />
           </fieldset>
           <button type="submit" class="btn btn-success">Submit</button>
       </form:form>
   </div>

<%@ include file="common/footer.jspf"%>

<script>
    $('#targetDate').datepicker({
    	format: "dd/mm/yyyy",
        weekStart: 1,
        multidate: false,
        daysOfWeekHighlighted: "0,6",
        calendarWeeks: true,
        autoclose: true,
        todayHighlight: true,
        toggleActive: true
    });
    
    /* $('#targetDate').daterangepicker({
        "singleDatePicker": true,
        "locale": {
            "format": "MM/DD/YYYY",
            "separator": " - ",
            "applyLabel": "Apply",
            "cancelLabel": "Cancel",
            "fromLabel": "From",
            "toLabel": "To",
            "customRangeLabel": "Custom",
            "weekLabel": "W",
            "daysOfWeek": [
                "Su",
                "Mo",
                "Tu",
                "We",
                "Th",
                "Fr",
                "Sa"
            ],
            "monthNames": [
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
            ],
            "firstDay": 1
        },
        "startDate": "12/23/2017",
        "endDate": "12/29/2017"
    }, function(start, end, label) {
      console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
    }); */
</script>
var calendarSettings = {};

	

calendarSettings.init = function(id) {
    Calendar.setup({
        inputField: id
        , ifFormat: "%Y-%m-%d"
        , weekNumbers: false
        , onUpdate: updateFunc1
        , position: [Calendar.getAbsolutePos(document.getElementById(id)).x, Calendar.getAbsolutePos(document.getElementById(id)).y + document.getElementById(id).offsetHeight]
    });
}

//없으면 에러 남.
function updateFunc1(cal) { }
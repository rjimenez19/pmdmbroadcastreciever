window.addEventListener("load", function(){
        var chart = new CanvasJS.Chart("chartContainer", {
		theme: "theme2",//theme1
		title:{
			text: "Detalles"
		},
		animationEnabled: false,   // change to true
		data: [              
		{
			// Change type to "bar", "area", "spline", "pie",etc.
			type: "column",
			dataPoints: [
				{ label: "Lunes",  y: InterfazAndroid.enviarDiaEntrantes(0)},
				{ label: "Martes", y: InterfazAndroid.enviarDiaEntrantes(1)  },
				{ label: "Miercoles", y: InterfazAndroid.enviarDiaEntrantes(2)  },
				{ label: "Jueves",  y: InterfazAndroid.enviarDiaEntrantes(3)  },
				{ label: "Viernes",  y: InterfazAndroid.enviarDiaEntrantes(4)  },
				{ label: "Sabado",  y: InterfazAndroid.enviarDiaEntrantes(5)  },
				{ label: "Domingo",  y: InterfazAndroid.enviarDiaEntrantes(6)  }
			]
		}
		]
	});
	chart.render();
});

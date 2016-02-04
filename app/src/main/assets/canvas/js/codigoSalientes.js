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
				{ label: "Lunes",  y: InterfazAndroid.enviarDiaSalientes(0)},
				{ label: "Martes", y: InterfazAndroid.enviarDiaSalientes(1)  },
				{ label: "Miercoles", y: InterfazAndroid.enviarDiaSalientes(2)  },
				{ label: "Jueves",  y: InterfazAndroid.enviarDiaSalientes(3)  },
				{ label: "Viernes",  y: InterfazAndroid.enviarDiaSalientes(4)  },
				{ label: "Sabado",  y: InterfazAndroid.enviarDiaSalientes(5)  },
				{ label: "Domingo",  y: InterfazAndroid.enviarDiaSalientes(6)  }
			]
		}
		]
	});
	chart.render();
});

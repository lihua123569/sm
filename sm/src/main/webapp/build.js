// node r.js -o build.js
({
	appDir: './',
	baseUrl: 'inc',
	dir: 'inc',
	paths: {
			jquery: 'jquery-1.11.3',
			jaliswall: 'wall/js/jaliswall',
			vue: 'vue'
	},
	keepBuildDir: true,
	preserveLicenseComments: false,
	fileExclusionRegExp: /^(test|r\.js|index\.html|index\.jsp|META-INF|build|output|node_modules|resources|todo|WEB-INF|commons|ocx|Gruntfile\.js|package\.json|README\.md|.*\.bat$|.*\.less$|.*\.map$|.*\.psd$)/,
	optimizeCss: 'standard',
	modules: [
		  {
			  name: "main/smwall",
			  exclude: ['jquery-1.11.3','vue','wall/js/jaliswall']
		  } 
	],
	allowSourceOverwrites: true
})

/*({
    appDir: '../www',
    mainConfigFile: '../www/js/common.js',
    dir: '../www-built',
    modules: [
        //First set up the common build layer.
        {
            //module names are relative to baseUrl
            name: '../common',
            //List common dependencies here. Only need to list
            //top level dependencies, "include" will find
            //nested dependencies.
            include: ['jquery',
                      'app/lib',
                      'app/controller/Base',
                      'app/model/Base'
            ]
        },

        //Now set up a build layer for each page, but exclude
        //the common one. "exclude" will exclude
        //the nested, built dependencies from "common". Any
        //"exclude" that includes built modules should be
        //listed before the build layer that wants to exclude it.
        //"include" the appropriate "app/main*" module since by default
        //it will not get added to the build since it is loaded by a nested
        //requirejs in the page*.js files.
        {
            //module names are relative to baseUrl/paths config
            name: '../page1',
            include: ['app/main1'],
            exclude: ['../common']
        },

        {
            //module names are relative to baseUrl
            name: '../page2',
            include: ['app/main2'],
            exclude: ['../common']
        }

    ]
})
*/
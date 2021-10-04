Usage: fahrul-cli from your command line
  -h, --help              	 				Displays this help message and quits.
  -o=<fileCopy>            					copy file
  -t=<fileToReadPath>    					Opens a file and path
  -t.json=<fileToReadPathjson>				Opens a file and view json
  -t.text=<fileToReadPathTxt>				Opens a file and view Text

  ex :

  run file fahrul-cli.jar

help
  	java -jar fahrul-cli.jar -h

 view text
 	java -jar fahrul-cli.jar -t.text "C:\xampp\apache\logs\error.log" 

 view json
 	java -jar fahrul-cli.jar -t.json "C:\xampp\apache\logs\error.log" 

 copy text
 	java -jar fahrul-cli.jar -t.text "C:\xampp\apache\logs\error.log" -o E:\\File Log.Error\copyfile.txt

 copy json
 	java -jar fahrul-cli.jar -t.json "C:\xampp\apache\logs\error.log" -o E:\\File Log.Error\copyfile2.json
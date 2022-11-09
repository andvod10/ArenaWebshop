App isn't finished.
There are two separate parts:
 - Add currency and Vat via browser
   1) For it should be started postgres DB. Can be used docker compose:
   run "docker-compose up -d"  command from command line
   2) Import postman collection file from docs/ folder and add all "Vat" and "Currency"
 - Execute command line. All params should be provided with names for them
   1) If should be calculated only cost without exchanges currency, then use params:
    "java -jar aw.jar -p 15.4 -t book -a 4 --vat GB"
      [-, --price] and [--vat] params are required
   2) With currency exchange
    "java -jar aw.jar -p 15.4 -t book -a 4 --vat GB --input-currency SEK --output-currency "

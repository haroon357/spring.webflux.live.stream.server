this is a simple demo project that get Customer data from PostgreSQL database in a reactive way using Flux
and then return this data as live stream Flux with  MediaType.TEXT_EVENT_STREAM_VALUE

Note: you will need to have a PostgreSQL database running locally and create customer table as per schema present in /resources folder 
Also insert some data to Customer table
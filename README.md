# Circuit Breaker
This app will try to connect to an external API called Bored API.  
If the rest call made by the web client fails the circuit breaker will be enabled.  
If an exception is thrown the fallback will be triggered.  
The fallback method just provides local data to the service to allow it to continue on in a half working state.  
This makes the service resilient to failures as the failing external API breaking doesn't cause the service to fail and throw an exception.  

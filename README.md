# Sunshine-Security

Vulnerabilities:
1. Services & Providers in Manifest
    
        Fix: Set exported="false"
        Fix: Set permissions to use those services
2. Logs being printed in production mode

        Fix: Custom Logger (SunshineLogger)
        
3. Insecure HTTP connection being used to get weather data

        Fix: Use an HTTPS connection for better security
        
4. Lint Results (53 issues)

        Fix: Fixed 24 issues
            (those with highest priority/security issues)
        

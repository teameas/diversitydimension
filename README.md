# DiversityDimension app

**Api deployment**

---
	
	 
  -  git clone github.com/teameas/diversitiydimension.git
  -  cd app/api
  -  mvn clean package
  -  gcloud config set account <gcp project account>
  -  gcloud app deploy.
---
	
 **Python web crawler deployment**
	
---
	
	
  -  git clone github.com/teameas/diversitiydimension.git
  -  cd app/crawler
  -  Login to GCP console
  -  Select CloudRun functions
  -  Copy python files and schedule script to deploy
  
---
	
  **Elastic App visualization**
	
---
	
  -  Create role to allow Java api to read/write to index
  -  Create user for api to access Elasatic apis
  -  Provides access to Kibana and App search UI for data view and analytics
  

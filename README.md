# android-service

Service
  Bound Service . : will stop when all client get disconnect
  normal Service  : will stop when stopself or stopservice is called
  Intent Service  : work on workerqueue model. Create a thread that read job from queue and execute sequentially.
                  once done. stop itself as stopself is called
  sticky service : stick to system. restart itself if killed                 
  
From Android Oreo Backgroung service is not allowed
instead Service will be start as startForgroundService and 
service need to publish notification using startforground
within 5 sec of creation.

Intent Service is also replaced by JobIntentService 
  

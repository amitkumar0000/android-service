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

jobIntentService works on workerQueue model. Internally jobIntentService uses JobService to dequeue work.
so it happen sequentially


Communication b/w activity and service
1. Via Interface
  passing object in intent bundle while starting service. Service reponse back on object callback.
2. Bound Seevice
  it establish client and server and can communicate.
3. BroadcastReceiver
   LocalBroadCast can be use for communication
  

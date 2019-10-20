# TEST JSON API

i7 920, 24GB RAM, ubuntu 16.04x64

`wrk -t8 -c400 -d10s http://localhost:8080/api/test`

## MainVerticle:

#### Deployed 1 verticle
```
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    14.05ms    0.98ms  36.26ms   97.14%
    Req/Sec     3.57k   195.12     4.59k    80.38%
  284565 requests in 10.07s, 27.95MB read
Requests/sec:  28265.35
Transfer/sec:      2.78MB
``` 

#### Deployed 4 verticle
```
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.09ms    4.32ms 218.39ms   85.51%
    Req/Sec     8.69k     1.48k   25.44k    84.38%
  693212 requests in 10.08s, 68.09MB read
Requests/sec:  68794.62
Transfer/sec:      6.76MB
```

#### Deployed 4 verticle, 1 thread for eventLoop
```
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    14.20ms    1.66ms 228.65ms   98.44%
    Req/Sec     3.52k   179.21     4.04k    84.50%
  280306 requests in 10.07s, 27.53MB read
Requests/sec:  27835.17
Transfer/sec:      2.73MB
```


## MainSimple:

#### 1 thread for eventLoop
```
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    14.00ms    1.56ms 222.57ms   90.86%
    Req/Sec     3.54k   257.76     4.76k    80.25%
  282082 requests in 10.05s, 27.71MB read
Requests/sec:  28054.80
Transfer/sec:      2.76MB
```

#### 4 threads for eventLoop
```
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    13.99ms    1.45ms 225.59ms   97.79%
    Req/Sec     3.59k   190.61     4.29k    78.62%
  285951 requests in 10.07s, 28.09MB read
Requests/sec:  28388.10
Transfer/sec:      2.79MB

```
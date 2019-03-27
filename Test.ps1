$url = 'http://localhost/myApp/HelloWorld'
$data = @{'heading' = '1987';'paragraph' = 'somelongthing'}

$Response = Invoke-RestMethod -Method Post -Uri $url -Body $(convertto-json $data) -ContentType 'application/json'
$Response
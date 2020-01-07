const express = require('express')
const app = express()
const bodyParser = require('body-parser')
   app.use(bodyParser.urlencoded({ extended: true }));
   //adding library twit
   const twit = require("twit")


// Start serv & listen on port 3000.
app.listen(3000, function () {
  console.log('Node listening on port 3000')
})

//Listen for get request on root url. eg. http://localhost:3000
app.set('view engine', 'ejs')
app.get('/', function (req, res) {
   res.render('index');

    if (req.body.hashtag !== null) {
//configure a new Twit instance with your API credentials
let Twitter = new twit({
    consumer_key: 'KP2T7qM3MJqKv1VP3l6UfKLzp',
    consumer_secret: 'ujtYhbXYWbTX1p7seyGSaRLDjp3atzWNYHabtvfa8xPC0WTHdx',
    access_token: '810110881782788097-y7bFLAKvIQVYrdDrPyg4QKi3c86W6Sk ',
    access_token_secret: 'aaoz9Xii9ISq3GRIE0iAaAo6ZtIf4u9F9NFJKcsoYNPW1 ',
    timeout_ms: 60 * 1000, // optional HTTP request timeout to apply to all requests.
    strictSSL: true, 
});

//searching for tweet
Twitter.get('search/tweets', {
    q: '#Code',
    count: 100,
    result_type: "mixed" 
  }).catch(function (err) {
    console.log('caught error', err.stack)
    res.render('index',{
        hashtag: null,
        TwitterData: null,
        error: err.stack
    });
  }).then(function (result) {
      res.render('index',{
          hashtag: req.body.hashtag,
          TwitterData: result.data,
          error:null
      });
    });
}
  });


  
   
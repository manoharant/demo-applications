var express = require('express');
var app = express();
var mongojs = require('mongojs');
var db = mongojs('contactlist', ['contactlist']);
var bodyParser = require('body-parser');

app.use(express.static(__dirname + "/public"));
app.use(bodyParser.json());

//Get request from db..
app.get('/contactlist', function (req, res) {
    console.log("I receieved a GET request..");

    db.contactlist.find(function (err, docs) {
        console.log(docs);
        res.json(docs);
    });
});

//Post request to db..
app.post('/contactlist', function (req, res) {
    console.log("I receieved a POST request..");
    console.log(req.body);
    db.contactlist.insert(req.body, function (err, docs) {
        console.log(docs);
        res.json(docs);
    });
});

//Delete request to db..
app.delete('/contactlist/:id', function (req, res) {
    console.log("I receieved a DELETE request..");
    var id = req.params.id;

    console.log("Delete request id:" + id);

    db.contactlist.remove({ _id: mongojs.ObjectId(id) }, function (err, doc) {
        console.log(doc);
        res.json(doc);
    });

});

//Get request to db..
app.get('/contactlist/:id', function (req, res) {
    console.log("I receieved a Get request..");
    var id = req.params.id;

    console.log("GET request id:" + id);

    db.contactlist.findOne({ _id: mongojs.ObjectId(id) }, function (err, doc) {
        console.log(doc);
        res.json(doc);
    });
});

//PUT request to db..
app.put('/contactlist/:id', function (req, res) {
    console.log("I receieved a PUT request..");
    var id = req.params.id;

    console.log("PUTs request id:" + req.body.name);

    db.contactlist.findAndModify({
        query: { _id: mongojs.ObjectId(id) },
        update: { $set: { name: req.body.name, email: req.body.email, number: req.body.number } },
        new: true
    },
        function (err, doc) {
            console.log(doc);
            res.json(doc);
        }
    );
});

app.listen("3000");

console.log("Server running in 3000..");
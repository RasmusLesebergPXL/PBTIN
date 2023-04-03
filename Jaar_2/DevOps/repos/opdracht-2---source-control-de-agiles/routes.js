const express = require('express');
const router = express.Router();

// Provide an /add endpoint followed by 2 values that will be added. Result is returned
// in JSON format
router.get('/add/:num1/:num2', function (req, res) {
    var num1 = parseInt(req.params.num1)
    var num2 = parseInt(req.params.num2)
    var sum = (num1 + num2).toString()
    res.json(sum)
})

// Provide an /subtract endpoint followed by 2 values that will be added. Result is returned
// in JSON format
router.get('/subtract/:num1/:num2', function (req, res) {
	
   var num1 = parseInt(req.params.num1)
    var num2 = parseInt(req.params.num2)
    var subtraction = (num1 - num2).toString()
    res.json(subtraction)
  
})


router.get('/divide/:num1/:num2', function (req, res) {
    var num1 = parseInt(req.params.num1)
    var num2 = parseInt(req.params.num2)
    var divide = (num1 / num2).toString()
    res.json(divide)
})



// Provide an /exponentiation endpoint followed by 2 values that will be used for the exponential operation. Result is returned
router.get('/exponentiation/:num1/:num2', function (req, res) {
  var num1 = parseInt(req.params.num1)
  var num2 = parseInt(req.params.num2)
  var exponential = Math.pow(num1, num2).toString();
  res.json(exponential)
})

// Provide a /multiplication  endpoint followed by 2 values that will be multiplied together. Result is returned
router.get('/multiplication/:num1/:num2', function (req, res) {
  var num1 = parseFloat(req.params.num1)
  var num2 = parseFloat(req.params.num2)
  var multiplier = (num1 * num2).toString()
  res.json(multiplier)
})


module.exports = router

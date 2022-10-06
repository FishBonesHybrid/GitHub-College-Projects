function validateForm(){
  var name_val = document.getElementById("name").value;
    if(name_val == null || name_val == ""){
        alert("Please enter name");
        return false;
      }

    if(name_val.length > 30){
        alert("Name cannot be longer than 30");
        return false;
      }

  var mobile_val = document.getElementById('mobile').value;
    if(mobile_val == null || mobile_val == ""){
      alert("Please enter your irish number");
      return false;
    }

    if(isNumeric(mobile_val) == false){
      alert("That's not an irish number, try again.");
      return false;
    }

  var email1_val = document.getElementById('email1').value;
    if(email1_val == null || email1_val == ""){
    alert("Please enter email");
    return false;

    }
  if(validateEmail(email1_val) == false){
    alert("invalid email format");
    return false;
    }

  var email2_val = document.getElementById("email2").value;
  if(email1_val != email2_val){
    alert("email fields must be the same");
    return false;
    }

  var text_val = document.getElementById('textbox').value;
  if(text_val == null || text_val == ""){
    alert("Please add any comment.");
    return false;
  }

function validateEmail(elementValue){
  var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailPattern.test(elementValue);
}

function isNumeric(numericValue){
  var numberPattern = /^\(?([0]{1})\)?[-. ]?([85-87]{2})[-. ]?([0-9]{7})$/;
  return numberPattern.test(numericValue);
}
}

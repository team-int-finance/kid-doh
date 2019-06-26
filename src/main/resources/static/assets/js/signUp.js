function checkPasswordMatch() {
            var password = $("#password").val();
            var confirmPassword = $("#conformPassword").val();

            if (password != confirmPassword)
            {
                $("#checkPasswordMatch").html("Passwords do not match!").css('color', 'red');
                $('#submit').prop('disabled', true);
            }
            else
            {
             $("#checkPasswordMatch").html("Passwords match.").css('color', 'green');
            $('#submit').prop('disabled', false);
            }
        }

$(document).ready(function () {
            $("#password, #conformPassword").keyup(checkPasswordMatch);
        });
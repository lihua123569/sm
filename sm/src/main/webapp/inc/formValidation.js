
/*regist.html*/
$(document).ready(function() {
	$('#registForm').formValidation({
	        message: 'This value is not valid',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            username: {
	                message: 'The username is not valid',
	                validators: {
	                    notEmpty: {
	                        message: '用户名必须设置'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: '用户名必须在6-30个字符之间'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_\.]+$/,
	                        message: '用户名只能由字母、数字、点和下划线组成'
	                    }
	                }
	            },
	            phone: {
	                validators: {
	                    notEmpty: {
	                        message: '手机号不能为空'
	                    },
	                    stringLength: {
	                        min: 11,
	                        max: 11,
	                        message: '手机号必须是11位'
	                    },
	                    regexp: {
	                        regexp: /^1[3|4|5|7|8]\d{9}$/,
	                        message: '手机号必须为11位数字组成，符合手机号组成结构'
	                    }

	                }
	            },
	            email: {
	            	validators: {
	            		notEmpty: {
	            			message: '电子邮件不能为空'
	            		},
	            		emailAddress: {
	            			message: '请输入有效的电子邮件地址'
	            		}
	            	}
	            },
	            password: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    different: {
	                        field: 'username',
	                        message: '密码不能和用户名相同'
	                    }
	                }
	            },
	            gender: {
	                validators: {
	                    notEmpty: {
	                        message: '必须选择一个性别'
	                    }
	                }
	            },
	            captcha: {
	                validators: {
	                    callback: {
	                        message: 'Wrong answer',
	                        callback: function(value, validator, $field) {
	                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
	                            return value == sum;
	                        }
	                    }
	                }
	            },
	            agree: {
	                validators: {
	                    notEmpty: {
	                        message: 'You must agree with the terms and conditions'
	                    }
	                }
	            }
	        }
	    })
	    .on('success.form.fv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the FormValidation instance
            var bv = $form.data('formValidation');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
            	if(result.responseCode!='0000'){
            		$('.modal').modal({backdrop: 'static', keyboard: false});
            		$('.modal').find('.modal-body').text(result.responseMsg);
            		setTimeout( function(){window.location.href='/sm/regist.html';  },1000)
            	}else{
            		$('.modal').modal({backdrop: 'static', keyboard: false});
            		setTimeout( function(){window.location.href='/sm/user.html';  },3000)
            	}
            }, 'json');
        });
});


/*login.html*/
$(document).ready(function() {
	$('#loginForm').formValidation({
	        message: 'This value is not valid',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            username: {
	                message: 'The username is not valid',
	                validators: {
	                    notEmpty: {
	                        message: '用户名必须设置'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 30,
	                        message: '用户名必须在6-30个字符之间'
	                    },
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_\.]+$/,
	                        message: '用户名只能由字母、数字、点和下划线组成'
	                    }
	                }
	            },
	            password: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    different: {
	                        field: 'username',
	                        message: '密码不能和用户名相同'
	                    }
	                }
	            } 
	        }
	    })
	    .on('success.form.fv', function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the FormValidation instance
            var bv = $form.data('formValidation');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
            	
            	if(result.responseCode!='0000'){
            		$('.modal').modal({backdrop: 'static', keyboard: false});
            		$('.modal').find('.modal-body').text(result.responseMsg);
            		setTimeout( function(){window.location.href='/sm/login.html';  },1000)
            	}else{
            		$('.modal').modal({backdrop: 'static', keyboard: false});
            		setTimeout( function(){window.location.href='/sm/user.html';  },3000)
            	}
            }, 'json');
        });
});


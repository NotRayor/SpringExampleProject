$('nav_inners').on('click',function(e){
  if(this.hash !=='') {
    e.preventDefault();

     hash = this.hash;

    $('html,body').animate({
      scrollTop: $(hash).offset().top
    }, 800);
  }
});

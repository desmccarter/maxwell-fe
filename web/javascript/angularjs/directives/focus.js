app.directive('focus', function () {
  return function (scope, element, attrs) {
    attrs.$observe('focus', function (newValue) {
        
        // this gives us the native JS object
        var el = element[0];
        
        el.draggable = true;

        el.addEventListener(
            'dragstart',
            function(e) {
                e.dataTransfer.effectAllowed = 'move';
                
                e.dataTransfer.setData('imageSrc',$("#"+newValue+" img").attr('src'));
                e.dataTransfer.setData('id',newValue);
                
                this.classList.add('drag');
                
                return false;
            },
            false
        );
        
        el.addEventListener(
            'dragend',
            function(e) {
                this.classList.remove('drag');
                return false;
            },
            false
        );
    });
  }
});
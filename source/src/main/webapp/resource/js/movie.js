/**
 * 
 */
/* //bxslide*/
  $(document).ready(function () {
            if ($('div.banner-slide ul').length > 0) {
                $('div.banner-slide ul').bxSlider({
                    mode: 'fade',
                    auto: true,
                    autoHover: true,
                    speed: 300,
                    pager: true,
                    pagerType: 'short',
                    //controller 부분 자동 생성
                    autoControls: true,
                    autoControlsCombine: true
                });
            }
        });
function tabSwap(tabIndex){
	var tabs=document.getElementById("tab").getElementsByTagName("li");
	for(var i=0;i<tabs.length;i++){
      if(i==tabIndex){
    	  tabs[i].style.color="#ff0000";
    	  tabs[i].style.background="url('../../images/main/tab_bg3.jpg') no-repeat";
    	  eval("tab1"+i).style.display="block";
      }else{
    	  tabs[i].style.color="#1b5ebe";
    	  tabs[i].style.background="url('../../images/main/tab_bg1.jpg') no-repeat";
    	  eval("tab1"+i).style.display="none";
      }
	}
}
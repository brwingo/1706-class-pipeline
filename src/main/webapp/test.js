/**
 * 
 */

function sum(x,y){
	if(y)
		return x+y;
	else{
		return function(y){
			return x + y;
		}
	}
}
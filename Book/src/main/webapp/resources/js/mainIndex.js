const quantities = document.getElementsByClassName("quantity");

for(let i of quantities) {
	
	i.addEventListener("input", function(e) {
		//console.log(e.target.value);
		if (e.target.value < 0) {
            alert("수량은 0 미만 설정이 불가 합니다.");
            this.value = 0;
        }
	});
	
	const thisElementButton = i.parentElement.nextElementSibling.children[0];

	thisElementButton.addEventListener("click", function(e) {
		
		//const inputElem = e.target.parentElement.previousElementSibling.children[0];
		
		console.log("inputElem::", i.value);
		
		if(!test(i.value)) {
			e.preventDefault();
		}
	});
}

/*
for (let i = 0; i < quantities.length; i++) {
    quantities[i].addEventListener("input", function() {
        const quantityValue = parseInt(this.value);
        if (quantityValue < 0) {
            alert("수량은 0 미만 설정이 불가 합니다.");
            this.value = 0;
        }
    });
}
*/

function test(count) {
    console.log("현재 인풋의 개수~!:: " + count);
    
    if (count <= 0) {
        alert("1권 이상부터 주문 가능.");
        return false;
    }else {
	    return true;
	}
}

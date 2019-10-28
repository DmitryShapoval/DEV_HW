function ListInterface () {}

ListInterface.prototype.push = function () {};
ListInterface.prototype.pop = function () {};
ListInterface.prototype.unshift = function () {};
ListInterface.prototype.shift = function () {};
ListInterface.prototype.sort = function () {};
ListInterface.prototype.size = function () {};
ListInterface.prototype.toString = function () {};
ListInterface.prototype.clearList = function () {};

function AList() {
    this.collection = [];
    this.length = 0;
}

AList.prototype.size = function (){
    if(arguments.length > 0) return false;
    let length = 0;
    for(let i = 0 ; this.collection[i] !== undefined; i++){
        length++
    }
    return length;
};

AList.prototype.clearList = function () {
    this.length = 0;
    this.collection = [];
};

AList.prototype.push = push = function (el) {
    if(arguments.length > 1 || arguments.length < 1) return false;
    this.collection[this.length] = el;
    this.length++;
};

AList.prototype.pop = function () {
    if(arguments.length > 0 || this.size() === 0) return false;
    let tempArray = [];
    for(let i = 0; i < this.length - 1; i++){
        tempArray[i] = this.collection[i];
    }
    this.collection = tempArray;
    this.length--;
};

AList.prototype.unshift = function (el) {
        if(arguments.length > 1 || arguments.length < 1) return false;
        let tempArray = [];
        let k = 0;
        for (let i = 0; i < this.length; i++){
            tempArray[k + 1] = this.collection[i];
            k++;
        }
        this.collection = tempArray;
        this.collection[0] = el;
        this.length++;
};

AList.prototype.shift = function () {
    if(arguments.length > 0 || this.size() === 0) return false;
    let tempArray = [];
    let k = 0;
    for (let i = 1; i < this.length; i++){
        tempArray[k] = this.collection[i];
        k++;
    }
    this.collection = tempArray;
    this.length--;
    return this.collection;
};

AList.prototype.toString = function () {
    let tmpString = '';
    for(let i = 0; i < this.size(); i++){
        tmpString += this.collection[i] + ',';
    }
    tmpString = tmpString.substring(0, tmpString.length - 1);

    return tmpString
};

AList.prototype.sort = function (compare) {
    if (compare) { //Правильный вызов aList.sort(function (a, b){return a - b});
        if (typeof compare == "function") {
            for (let i = 0; i < this.size(); i++) {
                for (let j = 0; j < this.size(); j++) {
                    if (j === this.size() - 1)
                        break;
                    if (compare(this.collection[j], this.collection[j + 1]) > 0) {
                        let tmp = this.collection[j + 1];
                        this.collection[j + 1] = this.collection[j];
                        this.collection[j] = tmp;
                    }
                }
            }
        }
        else {
            return false
        }
    }
    else {
        for (let i = 0; i < this.size(); i++) {
            for (let j = 0; j < this.size(); j++) {
                if (j === this.size() - 1)
                    break;
                if (String(this.collection[j]) > String(this.collection[j + 1])) {
                    let tmp = this.collection[j + 1];
                    this.collection[j + 1] = this.collection[j];
                    this.collection[j] = tmp;
                }
            }
        }
    }
};

AList.prototype.toLinkedList = function () {
    if(arguments.length > 0) return false;
    if(this.collection[0] === undefined) return false;
    let tmpLList = {
        root: {
            head: null,
            tail: null,
        }
    };

    function createTmpNode(el) {
        return {
            data: el ? el : null,
            prev : null,
            next: null,
        };
    };

    for(let i = 0; i < aList.size(); i++){
        let node =  createTmpNode(aList.collection[i]);
        if(!tmpLList.root.head){
            tmpLList.root.head = node;
            tmpLList.root.tail = node;
        }else{
            node.prev = tmpLList.root.tail;
            tmpLList.root.tail.next = node;
            tmpLList.root.tail = node;
            node.next = tmpLList.root;
        }
    }
    return tmpLList
};

function SuperAList() {
    AList.apply(this, arguments)
}

SuperAList.prototype = Object.create(AList.prototype);
SuperAList.prototype.constructor = SuperAList;

SuperAList.prototype.map = function(func){
    const tmpArray = [];
    for(let index = 0; index < this.collection.length; index++){
        tmpArray.push(func(this.collection[index], index, this.collection));
    }
    return tmpArray;
};

SuperAList.prototype.reduce = function(callBack, initValue){
    let callBackResult = 0;
    /*???let firstValue = this.collection[0];????*/
        if(initValue !== undefined){
            for(let i = 0; i < this.collection.length; i++) {
                callBackResult += callBack(initValue, this.collection[i], i, this.collection);
                initValue = 0;
            }
        }else{
            for(let i = 0 /*?1?*/; i < this.collection.length; i++) {
                initValue = 0;
                callBackResult += callBack(initValue /*?firstValue?*/, this.collection[i], i, this.collection);
                /*????firstValue = 0;???*/
            }
        }
    return callBackResult
};
/**/
SuperAList.prototype.reverse = function(){
    let tmpArr = [];
    let j = 0;
    for(let i = this.collection.length -1; i >= 0; i--){
        tmpArr[j] = this.collection[i];
        j++
    }
     this.collection = tmpArr;
};


function LList() {
    this.root = {
        head : null,
        tail : null,
        length :0,
    };
}

LList.prototype.clearList = function(){
    this.root = {
        head: null,
        tail: null,
        length: 0,
    }
};
LList.prototype.createNode = function (el) {
    return {
        data: el ? el : null,
        prev : null,
        next: null,
    };
};
LList.prototype.size = function () {
    if(arguments.length > 0) return false;
    return this.root.length;
};
LList.prototype.push = function (el) {
    if(arguments.length > 1 || arguments.length < 1) return false;
    let node =  this.createNode(el);

    if(!this.root.head){
        this.root.head = node;
        this.root.tail = node;
    }else{
        node.prev = this.root.tail;
        this.root.tail.next = node;
        this.root.tail = node;
        node.next = this.root;
    }
    this.root.head.prev = node;
    this.root.length++;
};
LList.prototype.pop = function () {
    if(arguments.length > 0 || this.root.head === null) return false;
    this.root.tail.prev.next = this.root;
    this.root.length--;
};
LList.prototype.unshift = function (el){
    if(arguments.length > 1 || arguments.length < 1) return false;
    let node = this.createNode(el);

    if(!this.root.head){
        this.root.head = node;
        this.root.tail = node;
    }else{
        node.prev = this.root;
        this.root.head.prev = node;
        node.next = this.root.head;
        this.root.head = node;
        this.root.tail.next = this.root;
    }
    this.root.length++
};
LList.prototype.shift = function(){
    if(arguments.length > 0 ) return false;
    if(this.root.head === null) return false;
    let tmpList = this.root.head.next;
    this.root.head = tmpList;
    this.root.length--;
};
LList.prototype.toString = function(){
    if(arguments.length > 0) return false;
    let tmpString = '';
    let tmpNoda = this.root.head;
    while(tmpNoda.next !== this.root){
        tmpString += tmpNoda.data + ',';
        tmpNoda = tmpNoda.next;
    }

    tmpString = tmpString.substring(0, tmpString.length - 1);

    return tmpString
};
LList.prototype.sort = function(compare){
    if (compare) {
        if (typeof compare == "function") {

            for (let i = 0; i < this.root.length; i++) {

                let tmpNoda = this.root.head;
                for (let j = 0; j < this.root.length; j++) {

                    if (tmpNoda.next === null) break;
                    if (compare(tmpNoda.data, tmpNoda.next.data) > 0) {
                        let tmp = tmpNoda.data;
                        tmpNoda.data = tmpNoda.next.data;
                        tmpNoda.next.data = tmp;
                    }
                    tmpNoda = tmpNoda.next;
                }
            }
        }
        else {
            return false
        }
    } else {
        for (let i = 0; i < this.root.length; i++) {
            let tmpNoda = this.root.head;

            for (let j = 0; j < this.root.length; j++) {

                if (tmpNoda.next === null) break;
                if (String(tmpNoda.data) > String(tmpNoda.next.data)) {
                    let tmp = tmpNoda.data;
                    tmpNoda.data = tmpNoda.next.data;
                    tmpNoda.next.data = tmp;
                }

                tmpNoda = tmpNoda.next
            }
        }
    }
};
LList.prototype.toArrayList = function(){
    if (arguments.length > 0) return false;
    if(this.root.head === null) return false;
    let node = this.root.head;
    let tmpArray = [];
    let i = 0;
    while(node.next !== this.root){
        tmpArray[i] = node.data;
        node = node.next;
        i++;
    }
    tmpArray[i] = node.data;

    return tmpArray;
};

function SuperLList() {
    LList.apply(this, arguments)
}

SuperLList.prototype = Object.create(LList.prototype);
SuperLList.prototype.constructor = SuperLList;

SuperLList.prototype.map = function (func) {
    const tmpArray = [];
    let tmp = this.root.head
    while(tmp !== this.root){
            tmpArray.push(func(tmp.data, tmp, this.root));
            tmp = tmp.next;
    }
    return tmpArray;
};
SuperLList.prototype.reduce = function(callBack,initValue) {
    let callBackResult = 0;
    let tmp = this.root.head;
    let i = 0;
    if(!initValue) initValue = 0;
    callBackResult += callBack(initValue, tmp.data, i, this.collection);
    initValue = 0;
    while(tmp.next!==this.root && tmp.data!==null){
        tmp = tmp.next;
        callBackResult += callBack(initValue, tmp.data, i, this.collection);
        console.log(callBackResult);
        i++;
    }
    return callBackResult;
};
SuperLList.prototype.reverse = function () {
    let curr = this.root.head;
    let tmp;
    while(curr !== this.root){
        tmp = curr.prev;
        curr.prev = curr.next;
        curr.next = tmp;
        curr = curr.prev;
    }
    this.root.head = tmp;
    this.root.head = this.root.tail
};

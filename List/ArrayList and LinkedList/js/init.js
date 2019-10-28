const ArrayList = {
    Collection: [] ,
    Length: 0 ,

    clearArray: function () {
        this.length = 0;
        this.Collection = [];
    },

    push: function(el){
        if(arguments.length > 1 || arguments.length < 1) return false;
        this.Collection[this.Length] = el;
        this.Length++;
    },

    pop: function(){
        let tempArray = [];
        for(let i = 0; i < this.Length - 1; i++){
            tempArray[i] = this.Collection[i];
        }
        this.Collection = tempArray;
        this.Length--;
    },

    size: function () {
        return this.Length;
    },

    shift: function () {
        let tempArray = [];
        let k = 0;
        for (let i = 1; i < this.Length; i++){
            tempArray[k] = this.Collection[i];
            k++;
        }
        this.Collection = tempArray;
        this.Length--;
        return this.Collection;

    },

    unshift: function(el){
        let tempArray = [];
        let k = 0;
        for (let i = 0; i < this.Length; i++){
            tempArray[k + 1] = this.Collection[i];
            k++;
        }
        this.Collection = tempArray;
        this.Collection[0] = el;
        this.Length++;
    },

    toString: function () {
        let tempArray = '';
        for (let i = 0; i < this.Length; i++){
            tempArray += `${this.Collection[i]},`;
        }
        tempArray = tempArray.substring(0, tempArray.length - 1);
        this.Collection = tempArray;

    },

    sort: function () {
        for (let i = 0; i < this.Collection.length; i++) {
            for (let k = i; k < this.Collection.length; k++) {

                if (this.Collection[k] < this.Collection[i]) {
                    let tempArr = this.Collection[i];
                    this.Collection[i] = this.Collection[k];
                    this.Collection[k] = tempArr;
                }
            }
        }
    },


};

const LinkedList = {
    root: {
        head : null,
        tail : null,
        length :0,
    },

    createNode: function(el) {
        return {
            data: el ? el : null,
            prev : null,
            next: null,
        };
    },

    size: function () {
        return `LinkedList size = ${this.root.length}`;
    },

    push: function(el) {
        let node =  this.createNode(el);

        if(!this.root.head){
            this.root.head = node;
            this.root.tail = node;
        }else{
            node.prev = this.root.tail;
            this.root.tail.next = node;
            this.root.tail = node;
        }
        this.root.length++;
    },

    pop: function(){
        if(!this.root.head) return null

        const prevNode = this.root.tail.prev

        if(prevNode){
            prevNode.next = null;
            this.root.tail = prevNode;
        }else{

            this.root.head = null;
            this.root.tail = null;
        }
        this.root.length--;
    },

    unshift: function(el){
        let node =  this.createNode(el);

        if(!this.root.head) {
            this.root.head = node;
            this.root.tail = node;
        }else{
            this.root.head.prev = node
            node.next = this.root.head;
            this.root.head = node;
        }
        this.root.length++;

    },

    shift: function(){
        if(!this.root.head) return null;
        const node = this.root.head.next;
        if(node){
            node.prev = null
            this.root.head = node
        }else{
            this.root.head = null
            this.root.tail = null
        }
        this.root.length--;
    },

    toString: function(){
        if(!this.root.head) return null;
        let node = this.root;
        node = node.head;
        let string = node.data;
        while (node.next != null) {
            node = node.next;
            string += ", "  + String(node.data) ;
        }
        return string;
    },

    toArrayList:  function () {
        let node = this.root.head;
        let tmpArray = [];
        let i = 0;

        while (node.next!= null) {
           tmpArray[i] = node.data;
           i++;
           node = node.next;
        }

        tmpArray[i] = node.data;
        ArrayList.Collection = tmpArray;
        console.log(tmpArray)
        return tmpArray;
    },
    sort: function(compare){

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
        }
};













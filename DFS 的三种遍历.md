### DFS 的三种遍历

####  1. 前序遍历

这里有两种方式，一种是迭代，一种是递归，递归很简单，不断的调用本身就好，但是记住不能在递归上使用while循环，这样会造成死循环

先说迭代

首先，我们定义一个新的类，这个类虽然在先序遍历上没有很大的作用，但是按照这个方法，我们可以把三种遍历都形成体系的遍历完

这个类就是对之前的那个树节点的一个重新构造，string是为了标示现在的这个节点是否要出栈

然后首先，由于我们用的是栈结构，所有说，先序遍历的特征是 中左右。但是栈是一个先入后出的数据结构，因此，我们先把根节点入栈，由于每次我们都是先访问中间节点，因此先将这个入栈的节点pop出来。判断当前这个节点的左右节点，不过得先右后左，原因还是栈的数据结构特性，我们要先访问左边的节点的话，那就只有后面入栈。

![image-20200829221330272](C:\Users\Administrator.PC-20171120YKOX\AppData\Roaming\Typora\typora-user-images\image-20200829221330272.png)

如图，1先入栈，然后循环判断当前栈是否为空，然候将现在的栈顶出栈，用一个新的节点来保存，叫做temp，所以当前的temp是1，并且这个时候栈为空，判断temp是否有右节点，如果有，入栈，然候判断是否有左节点，也入栈，然后一轮判断结束后，这个时候栈顶就是temp的左节点，那么这个时候将左节点出栈，赋值给新的temp，那么这顺序也是符合先序遍历的，然后又循环判断，当前节点的右节点，左节点，栈顶出栈，直到栈为空。

最后得出， 1-2-4-3-5

``` java
class command{
    String res;
    TreeNode node;
    command(String res, TreeNode node){
        this.res = res;
        this.node = node;
    }
}

class Solution{
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList();
         Stack<command> stack = new Stack();
         if(root == null) return list;
         stack.push(new command("go",root));
         while(!stack.isEmpty()){
             command temp = stack.pop();
            list.add(temp.node.val);
             if(temp.node.right!=null){
                 stack.push(new command("go",temp.node.right));
             }
             if(temp.node.left != null){
                 stack.push(new command("go",temp.node.left));
             }
         }
          return list;
     }
    
}
}
```

#### 2. 中序遍历

中序遍历是左中右，那么就是说，我们得先把中间的节点存起来，然后往右走，中间走，往左走

逻辑是这样的，首先我们将

![image-20200829230447192](C:\Users\Administrator.PC-20171120YKOX\AppData\Roaming\Typora\typora-user-images\image-20200829230447192.png)

将1入栈，并且加上标示为go, 当站不为空的时候， 定义一个新的节点 temp为当前的栈顶元素，这个时候需要判断一下， 这个元素的右节点有没有，如果有，入栈，标示为go,然后将这个中间节点入栈，也就是当前的在那个节点，之前入栈了，然后被出栈，现在又入栈，但是标示不一样。现在的标示为visit,代表着，这个节点以及被访问过了。一轮下来，我们的栈里面存的值顺序是 go,3 -visit,1 -go,2,然后这个时候循环又到了栈顶，将栈顶元素取出来，也就是这里的 go,2,也是判断这个点的右左节点，按照右节点， 临时节点，左节点的顺序入栈，当然temp节点的标示为 visit。这个时候，栈里面的结构是 go 3 - visit 1 - visit 2 - go 4,然后再循环，temp = go 4,出栈又入栈，此时站内为 go 3-vi1-vi2-vi4,这个时候，循环就要把对应的栈顶的值输出，因为此时的标示都是visit,list既可以将顺序的值加入列表中，当反问到了go3的时候，这次循环得到的是，3先出栈，然后判断3的右节点，5入栈，标示为go,3入栈，标示为visit，然后循环栈顶。栈顶出栈，3出来，然后循环栈顶，5出栈。5又入栈，这个时候5的标示就是visit。然后栈空，程序结束。

42135

总得来说，就是打印值为visit的那个节点

``` java
class command{
     String res;
     TreeNode node;
     command(String res, TreeNode node){
         this.res = res;
         this.node = node;
     }
 }

class Solution{
     public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList();
         Stack<command> stack = new Stack();
         if(root == null) return list;
         stack.push(new command("go",root));
         while(!stack.isEmpty()){
             comand temp = stack.pop();
             if(temp.node,val == "go"){
                 if(temp.node.right!=null){
                     stack.push(new command("go",temp.node.right));
                 }
                 stack.push(new command("visit",temp.node));
                 if(temp.node.left!=null){
                     stack.push(new command("go",temp.node.left));
                 }
             }else{
                 list.add(temp.node.val);
             }
         } 
     }
}
```



#### 3. 后序遍历

思想与中序遍历很像，中序遍历是临时节点出栈后，先将右节点入栈，然后中间节点，然后左节点，但是这在这里就是，先将中间节点入栈，然后右节点，然后左节点。

![image-20200829232700522](C:\Users\Administrator.PC-20171120YKOX\AppData\Roaming\Typora\typora-user-images\image-20200829232700522.png)

一开始，将根节点 1入栈，表示为go,然后循环栈，栈顶元素出栈变成临时节点，然后将这个节点又入栈，但是这个时候是visit,右节点，go 3, 左节点 go 2,  v1-g3-g2这个时候栈顶为go2,又来循环，2出栈为临时节点，入栈为visit2,左节点 go 4,  v1-g3-v2-g4,然后4出栈，入栈，然后4存入list中。栈顶到2了，2存入list中，栈顶为g3,进入循环，入栈 v3，g5,     v1-v3-g5,   然后5出栈入栈为v5,list 存入5，v3出栈， v1出栈，栈为空，结束

42531

``` java
class command{
    String res;
    TreeNode node;
    command(String res, TreeNode node){
        this.res = res;
        this.node = node;
    }
}
class Solution{
    public List<Integer> parorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
         Stack<command> stack = new Stack();
         if(root == null) return list;
         stack.push(new command("go",root));
         while(!stack.isEmpty()){
             command temp = stack.pop();
             if(temp.node.res == "go"){
                 stack.push(new command("visit",temp.node));
                 if(temp.node.right !=null){
                     stack.push(new command("go",temp.node.right));
                 }
                 if(temp.node.left!=null){
                     stack.push(new command("go",temp.node.left));
                 }
             }else{
                 list.add(temp.node.val);
             }
         } 
        return list;
    }
}
```


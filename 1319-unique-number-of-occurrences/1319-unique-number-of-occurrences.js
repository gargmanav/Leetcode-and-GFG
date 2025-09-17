/**
 * @param {number[]} arr
 * @/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
   
    const obj = {}
   for(let char of arr){
        obj[char] = (obj[char] || 0) + 1
    }
    console.log(obj)
   const newarr =  Object.values(obj)
   console.log(newarr)
   const res = Array.from(new Set(newarr))
   console.log(res)
   if(res.length === newarr.length){
       return true
   }
   return false
};
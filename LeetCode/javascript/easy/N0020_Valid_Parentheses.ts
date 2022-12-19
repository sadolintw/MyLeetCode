function isValid(s: string): boolean {
  let map:{[key:string]:any} = {
    ')': '(',
    '}': '{',
    ']': '['
  }
  let result = true
  let stack:Array<string> = []

  for (let i = 0; i < s.length; i++) {
    if(map[s[i]]){
      let top:string|undefined = ''
      top = stack.pop()
      if(top!=map[s[i]])
        return false
    }else{
      stack.push(s[i])
    }
  }

  if(stack.pop()){
    return false
  }

  return result;
};

function main() {
  console.log(isValid('()'))
  console.log(isValid('()[]{}'))
  console.log(isValid('(]'))
  console.log(isValid('[(])'))
  console.log(isValid('['))
}

main()
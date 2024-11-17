def main (file: []u8) =
  let potion (c: u8): i32 =
    match c
    case 'C' -> 3
    case 'B' -> 1
    case _ -> 0
  in map potion file
     |> reduce (+) 0

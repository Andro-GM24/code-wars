module Grow (grow) where

grow :: [Int] -> Int--get a list and return the product of the elements
grow []=1-- if xs is empty because there isn´t more elements return a 1 and finally the 
--product and dont make and error in the function
grow (x:xs)= x*grow(xs) --(x:Xs) take the first value  to x and xs is the rest of the list
--making a recursive function multiplying the first number of every call of grow

main :: IO()
main = do
    let list=[1,2,3,4]
    let multip=grow list
    putStrLn ("the multiplying of the list is " ++ show multip)
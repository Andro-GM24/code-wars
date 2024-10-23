import Data.List (sort)

import Prelude hiding (minimum, maximum)

minimum :: [Int] -> Int
minimum minimo = head(sort minimo)

maximum :: [Int] -> Int
maximum maximo =last(sort maximo)

main :: IO ()
main = do
    let d0 = [7,4,3,21,45,2,234,23,2]
    let minValor = minimum d0  
    let maxValor = maximum d0  
    putStrLn ("El valor mínimo es: " ++ show minValor)  -- Imprime los valores maximos y minimos
    putStrLn ("El valor máximo es: " ++ show maxValor)
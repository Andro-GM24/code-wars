numberToString :: Int -> String
numberToString num = show (num)

main :: IO ()
main = do
    let number = 84
    let stringNumber = numberToString number
    putStrLn stringNumber
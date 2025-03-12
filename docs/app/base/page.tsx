import { Box, Typography } from "@mui/material"
import Link from "next/link"
import { ReactElement } from "react"

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Android UI - Base Functionality</Typography>


        <Box>
            <Link href={"./base/layout/"}>Getting Started - <code>RootLayout</code></Link>
            <br />
            <Link href={"./base/router/"}>Router and RouterProvider</Link>
        </Box>
    </div>)
}

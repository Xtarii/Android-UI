import CodeBlock from "@/components/code/code";
import { Box, Typography } from "@mui/material";
import { ReactElement } from "react";

export default function Page() : ReactElement {
    return(<div>
        <Typography variant="h4">Suspended</Typography>
        <Box>
            <Typography>
                When a component uses data that needs to be fetched, the <code>Suspended</code> component
                can be used to load the component and provide a fallback component while waiting.
            </Typography>
            <CodeBlock>{
                'Suspended(fallback = { /* Load */ }) {\n' +
                    "\t// Suspended Data handling\n\n" +

                    "\t({ /* Loaded */ })\n" +
                "}\n"
            }</CodeBlock>
        </Box>
    </div>)
}
